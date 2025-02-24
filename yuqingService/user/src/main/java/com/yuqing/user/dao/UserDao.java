package com.yuqing.user.dao;

import com.yuqing.user.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {
  @Select("SELECT * FROM user")
    List<User> getAllUser();
  //修改为账户
  @Update("UPDATE user SET password = #{password} WHERE account = #{account}")
    boolean changePassword(User user);
}
