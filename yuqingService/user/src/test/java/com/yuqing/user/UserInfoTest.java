package com.yuqing.user;

import com.yuqing.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserInfoTest {
    @Autowired
    private UserService userService;
//    public UserInfoTest(UserService userService) {
//        this.userService = userService;
//    }
    @Test
    public void
    getUserInfo() {
        System.out.println(userService.getAllUser());
    }
}
