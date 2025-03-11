package com.yvqing.loginregister.dto;


import com.yuqing.user.bean.User;
import lombok.Data;

/**
 * UserRegistrationDto class.
 *
 * @author Administrator
 * @since 2025/2/13
 */
@Data
public class UserRegistrationDto {
    // Class implementation goes here
    private User user;
    private String method;

}
