package com.yvqing.loginregister.controller;


import com.yuqing.common.UserOptLogger;
import com.yuqing.user.bean.User;
import com.yvqing.loginregister.dto.LoReDto;
import com.yvqing.loginregister.dto.UserRegistrationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.yvqing.loginregister.service.LoginRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * IndexController class.
 *
 * @author Administrator
 * @since 2025/1/12
 */
@RestController
@CrossOrigin
@Tag(name = "登录注册控制器", description = "用户登录注册测试接口")
public class LoReController {


    private final LoginRegisterService loginRegisterService;

    public LoReController(LoginRegisterService loginRegisterService) {
        this.loginRegisterService = loginRegisterService;
    }

    @UserOptLogger(operation = "用户使用账号登录")
    @PostMapping("/accountlogin")
    @Operation(summary = "账号登录", description = "这是账号登录的方法")
    public ResponseEntity<LoReDto> accountLogin (@RequestBody User user) {
//        System.out.println("test accountlogin" + user.getPassword());
        LoReDto reDto = loginRegisterService.accountlogin(user);
        System.out.println(reDto.getResp());
        System.out.println("test getToken ："+reDto.getToken());
        return ResponseEntity.ok(reDto);
    }
    @UserOptLogger(operation = "用户使用手机号登录")
    @PostMapping("/phonelogin")
    @Operation(summary = "手机短信登录", description = "这是手机短信登录的方法")
    public ResponseEntity<LoReDto> phoneLogin(@RequestBody User user) {
        System.out.println("test phonelogin" + user.getTelephone());
        LoReDto reDto = loginRegisterService.phonelogin(user);
        System.out.println(reDto.getResp());
        return ResponseEntity.ok(reDto);
    }
    @UserOptLogger(operation = "用户使用手机号注册")
    @PostMapping("/register")
    @Operation(summary = "手机号注册", description = "这是手机号注册的方法")
    public ResponseEntity<LoReDto> register(@RequestBody UserRegistrationDto user) {
        System.out.println("test register" + user.getUser().getTelephone());
        LoReDto reDto = loginRegisterService.register(user);
        System.out.println(reDto.getResp());
        System.out.println(reDto.getTelephone());
        return ResponseEntity.ok(reDto);
    }



    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "yes";

    }


    @RequestMapping("/get")
    public User getUser(User daouser) throws Exception {
        User user = new User();
        user.setId(1);
        user.setEmail("123@qq,com");
        System.out.println("test:");
        System.out.println(daouser);
        System.out.println(daouser.getEmail());
        System.out.println(daouser.getId());
        return user;
    }

}
