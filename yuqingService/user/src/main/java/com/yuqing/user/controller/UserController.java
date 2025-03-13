package com.yuqing.user.controller;

import com.yuqing.common.UserOptLogger;
import com.yuqing.user.bean.ChangePasswordUser;
import com.yuqing.user.bean.User;
import com.yuqing.user.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yuqing.user.properties.UserProperties;
import com.yuqing.user.service.UserService;
//@RefreshScope
@RestController
@RequestMapping("/user")
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

@CrossOrigin(origins = "http://localhost:8080")
@UserOptLogger(operation = "用户修改密码")
    @PostMapping("/changePassword")
    public Result changePassword(@RequestBody ChangePasswordUser user){
        String userChangePassword = userService.changePassword(user);
        if ( userChangePassword.equals("修改成功"))
        return Result.success("成功修改密码");
        if (userChangePassword.equals("密码错误"))
            return Result.error("原密码错误，请重新输入");
        else return Result.error("修改密码失败");
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @UserOptLogger(operation = "用户查看账号信息")
    @PostMapping("/showAccount")
    public Result showCurUserInfo(@RequestBody ChangePasswordUser user){
        return Result.success(userService.showCurUserInfo(user));
    }
}
