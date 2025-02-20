package yuqing.com.user.dao;

import com.yuqing.user.bean.User;
import org.springframework.stereotype.Service;
import yuqing.com.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(int userId) {
        User user = new User();
        user.setId(0);
        user.setUsername("y");
        user.setPassword("123456");
        user.setEmail("33");
        user.setPhone(123456789);
        return user;
    }
}
