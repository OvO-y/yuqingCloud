package yuqing.com.userInfo.dao;

import org.springframework.stereotype.Service;
import yuqing.com.userInfo.entity.User;
import yuqing.com.userInfo.service.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public User getUserInfoById(int userId) {
        User user = new User();
        user.setId(0);
        user.setUsername("y");
        user.setPassword("123456");
        user.setEmail("33");
        user.setPhone(123456789);
        return user;
    }
}
