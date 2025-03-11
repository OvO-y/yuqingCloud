package com.yvqing.loginregister.service;

import com.yuqing.user.bean.User;
import com.yvqing.loginregister.dto.LoReDto;
import com.yvqing.loginregister.dto.UserRegistrationDto;

public interface LoginRegisterService {

    LoReDto accountlogin(User user);

    LoReDto phonelogin(User user);

    LoReDto register(UserRegistrationDto user);
}
