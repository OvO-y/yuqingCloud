package com.yvqing.loginregister.service;


import com.yuqing.user.bean.User;
import com.yvqing.loginregister.converter.LoReConverter;
import com.yvqing.loginregister.dao.LoReDao;
import com.yvqing.loginregister.dto.LoReDto;
import com.yvqing.loginregister.dto.UserRegistrationDto;
import com.yvqing.loginregister.handler.UserNotFoundException;
import com.yvqing.loginregister.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Administrator
 * @since 2025/2/12
 */
@Service("LoginRegisterImpl")
public class LoginRegisterImpl implements LoginRegisterService {
    private final LoReDao loReDao;
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    public LoginRegisterImpl(LoReDao loReDao) {
        this.loReDao = loReDao;
    }

    @Override
    public LoReDto accountlogin(User user) {
        LoReDto foundDto = new LoReDto();
        User foundUser = findUserByAccount(user);
        String resp = null;

        if (foundUser == null) {
            resp = "User not found by Account"; // 直接设置错误信息
            foundDto.setResp(resp);
            return foundDto;          // 返回 DTO，不抛出异常
        }

        // 检查密码
//        这里可能需要添加校验数据库里面密码是否为空的情况
        if (!foundUser.getPassword().equals(user.getPassword())) {
            resp = "Password is wrong";
            foundDto.setResp(resp);
            return foundDto;
        }

        // 登录成功逻辑
        foundDto = LoReConverter.convertToUserDto(foundUser);
        foundDto.setResp("Account Login successfully");
        foundDto.setToken(JwtUtil.createToken());
        return foundDto;
    }

    // 通过一个方法根据多种条件查询用户
    public User findUserByAccount(User user) {
        List<User> userList;

        if (user.getAccount() != null) {
            userList = loReDao.getUserByAccount(user.getAccount());
            if (userList.isEmpty()) {
                userList = loReDao.getUserByPhone(user.getAccount());
                if (userList.isEmpty()) {
                    userList = loReDao.getUserByEmail(user.getAccount());
                }
            }
        } else {
            return null;
        }

        // 检查列表是否为空
        return (userList != null && !userList.isEmpty()) ? userList.get(0) : null;
    }

    @Override
    public LoReDto phonelogin(User user) {

        LoReDto foundDto = new LoReDto();
        User foundUser = findUserByPhone(user);
        String resp = null;
        if (foundUser == null) {
            resp = "User not found by Phone";
            foundDto.setResp(resp);
            return foundDto;
        }

        //        此处添加处理验证码的逻辑（暂时无需）

        foundDto = LoReConverter.convertToUserDto(foundUser);
        foundDto.setResp("Phone login successfully");
        foundDto.setToken(JwtUtil.createToken());
        return foundDto;
    }

    public User findUserByPhone(User user) {
        List<User> userList;
        if (user.getTelephone() != null) {
            userList = loReDao.getUserByPhone(user.getTelephone());
        } else {
            return null;
        }
        // 检查列表是否为空
        return (userList != null && !userList.isEmpty()) ? userList.get(0) : null;
    }

    @Override
    public LoReDto register(UserRegistrationDto userDto) {
        int re = 0;
        LoReDto reDto = new LoReDto();
        User reUser = new User();
        if (registerSearch(userDto) != null) {
            reDto.setResp("User has been registered");
            return reDto;
        } else {
            userDto.getUser().setCreate_time(LocalDateTime.now());
            if (userDto.getMethod().equals("phone")) {
                re = loReDao.addUserByPhone(userDto.getUser());
                reUser = loReDao.getUserByPhone(userDto.getUser().getTelephone()).get(0);
            } else if (userDto.getMethod().equals("email")) {
                re = loReDao.addUserByEmail(userDto.getUser());
                reUser = loReDao.getUserByEmail(userDto.getUser().getEmail()).get(0);
            }
        }
        userDto.getUser().setCreate_time(LocalDateTime.now());

        System.out.println("test " + re);

        if (re == 1) {
            reDto.setResp("Register successfully");
            if(reUser != null) {
                reDto.setAccount(reUser.getAccount());
                reDto.setTelephone(reUser.getTelephone());
                reDto.setToken(JwtUtil.createToken());
            }else {
                reDto.setResp("Can not find registered user");
            }

        };

        return reDto;
    }

    public User registerSearch(UserRegistrationDto userDto) {
        User user = userDto.getUser();
        List<User> userList = List.of();
        if (userDto.getMethod().equals("phone")) {
            if (user.getTelephone() != null) {
                userList = loReDao.getUserByPhone(user.getTelephone());
            } else {
                return null;
            }
        } else if (userDto.getMethod().equals("email")) {
            if (user.getEmail() != null) {
                userList = loReDao.getUserByEmail(user.getEmail());
            } else {
                return null;
            }
        }

        // 检查列表是否为空
        return (userList != null && !userList.isEmpty()) ? userList.get(0) : null;
    }

}
