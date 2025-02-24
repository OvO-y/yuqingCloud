package com.yuqing.user.implement;

import com.yuqing.user.bean.User;
import com.yuqing.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuqing.user.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public String changePassword(User user) {
        if (userDao.changePassword(user)){
            return new String("成功");
        }else return new String("失败");
    }
}
