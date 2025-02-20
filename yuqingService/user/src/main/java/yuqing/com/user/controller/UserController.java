package yuqing.com.user.controller;

import com.yuqing.user.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yuqing.com.user.properties.UserProperties;
import yuqing.com.user.service.UserService;
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
}
