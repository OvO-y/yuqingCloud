package com.yuqing.user.dao;

import com.yuqing.user.bean.ChangePasswordUser;
import com.yuqing.user.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
  @Select("SELECT * FROM user")
    List<User> getAllUser();
  //修改为账户
  @Update("UPDATE user SET password = #{password} WHERE account = #{account}")
    boolean changePassword(@Param("account") String account,@Param("password") String password);
@Select("SELECT * from user where account = #{account}")
  User findCurUser(@Param("account") String account);
}
