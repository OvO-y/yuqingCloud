package com.yuqing.user.implement;

import com.yuqing.user.bean.ChangePasswordUser;
import com.yuqing.user.bean.User;
import com.yuqing.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuqing.user.service.UserService;

import java.util.List;
import java.util.Objects;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    //校验密码
    @Override
    public String changePassword(ChangePasswordUser user) {
        System.out.println("=========");
        System.out.println(user);
        System.out.println("=========");
        String oldPassword = user.getOldPassword();
        String account = user.getAccount();
        String password = userDao.findCurUser(account).getPassword();
        User dbUser = userDao.findCurUser(user.getAccount());
        System.out.println("=========");
        System.out.println(dbUser);
        System.out.println("=========");
        if (dbUser == null) {
            return "用户不存在"; //
        }
        if (!Objects.equals(password, oldPassword)){
            return "密码错误";
        }
        if (userDao.changePassword(user.getAccount(),user.getPassword())){
            return "修改成功";
        }else return "修改失败";
    }

    @Override
    public User showCurUserInfo(ChangePasswordUser user) {
        return userDao.findCurUser(user.getAccount());
    }
}
