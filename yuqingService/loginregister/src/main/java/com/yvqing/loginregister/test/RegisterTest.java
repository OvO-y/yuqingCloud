package com.yvqing.loginregister.test;


import com.yuqing.user.bean.User;
import com.yvqing.loginregister.dao.LoReDao;
import com.yvqing.loginregister.dto.LoReDto;
import com.yvqing.loginregister.dto.UserRegistrationDto;
import com.yvqing.loginregister.service.LoginRegisterImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegisterTest {

    @InjectMocks
    private LoginRegisterImpl loginRegisterImpl;

    @Mock
    private LoReDao loReDao;

    @Test
    public void testRegister_EmailExists() {
        // 模拟邮箱已被注册的情况
        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.getUser().setEmail("existing@example.com");

        when(loReDao.findUserByEmail("existing@example.com")).thenReturn(1);

        LoReDto result = loginRegisterImpl.register(userDto);

        assertEquals("Email has been registered", result.getResp());
    }

    @Test
    public void testRegister_PhoneExists() {
        // 模拟手机号已被注册的情况
        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.getUser().setTelephone("1234567890");

        when(loReDao.findUserByPhone("1234567890")).thenReturn(1);

        LoReDto result = loginRegisterImpl.register(userDto);

        assertEquals("Phone has been registered", result.getResp());
    }

    @Test
    public void testRegister_RegisterSuccessfully_ByPhone() {
        // 模拟通过手机号注册成功的情况
        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.getUser().setTelephone("newphone@example.com");
        userDto.setMethod("phone");

        when(loReDao.findUserByEmail("newphone@example.com")).thenReturn(0);
        when(loReDao.findUserByPhone("newphone@example.com")).thenReturn(0);
        when(loReDao.addUserByPhone(any(User.class))).thenReturn(1);

        LoReDto result = loginRegisterImpl.register(userDto);

        assertEquals("Register successfully", result.getResp());
    }

    @Test
    public void testRegister_RegisterSuccessfully_ByEmail() {
        // 模拟通过邮箱注册成功的情况
        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.getUser().setEmail("newemail@example.com");
        userDto.setMethod("email");

        when(loReDao.findUserByEmail("newemail@example.com")).thenReturn(0);
        when(loReDao.findUserByPhone("newemail@example.com")).thenReturn(0);
        when(loReDao.addUserByEmail(any(User.class))).thenReturn(1);

        LoReDto result = loginRegisterImpl.register(userDto);

        assertEquals("Register successfully", result.getResp());
    }


    @Test
    public void register() {
        User user = new User();
        user.setEmail("newemail@example.com");
        user.setTelephone("1234567890");
        user.setPassword("password");
        int re = 0;
        LoReDto reDto = new LoReDto();
        if (loReDao.findUserByEmail(user.getEmail()) != 0) {
            reDto.setResp("Email has been registered");

        } else if (loReDao.findUserByPhone(user.getTelephone()) != 0) {
            reDto.setResp("Phone has been registered");

        }
        user.setCreate_time(LocalDateTime.now());

        re = loReDao.addUserByPhone(user);

        System.out.println("test " + re);

        if (re == 1) {
            reDto.setResp("Register successfully");
        }
    }

}
