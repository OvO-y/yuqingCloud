package com.yvqing.loginregister.dao;

import com.yuqing.user.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LoReDao {
    List<User> findALL();

    List<User> getUserByAccount(String account);
    List<User> getUserByPhone(String telephone);
    List<User> getUserByEmail(String email);


    int addUserByPhone(User user);
    int addUserByEmail(User user);
    int findUserByPhone(String telephone);
    int findUserByEmail(String email);

}
