package yuqing.com.userInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yuqing.com.userInfo.entity.User;
import yuqing.com.userInfo.service.UserInfoService;
@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
@GetMapping("/userInfo/{id}")
    public User getUserInfo(@PathVariable("id") int userId) {
    //路径取出商品id
        User user=userInfoService.getUserInfoById(userId);
        return user;
    }
}
