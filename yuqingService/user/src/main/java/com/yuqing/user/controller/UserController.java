package com.yuqing.user.controller;

import com.yuqing.user.bean.User;
import com.yuqing.user.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yuqing.user.properties.UserProperties;
import com.yuqing.user.service.UserService;
//@RefreshScope
@RestController
public class UserController {
    @Autowired
    private UserService userService;

//    @Value("${user.timeout}")
//    String userTimeout;
//    @Value("${user.auto-confirm}")
//    String userAutoConfirm;
    @Autowired
    UserProperties userProperties;
    @GetMapping("/config")

    public String config() {
        return "user.timeout=" + userProperties.getTimeout()+ "; user.auto-confirm = " + userProperties.getAutoConfirm();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int userId) {
        //路径取出商品id
        User user = userService.getUserById(userId);
        return user;
    }
    @PostMapping("/user/getInfo")
    public User getInfo(User user){
        userService.getAllUser();
        return user;
    }
    @PostMapping("/user/changePassword")
    public Result changePassword(@RequestBody User user){
        String userChangePassword = userService.changePassword(user);
        return Result.success(userChangePassword);
    }
}
