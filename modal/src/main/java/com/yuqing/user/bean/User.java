package com.yuqing.user.bean;

import co.elastic.clients.util.DateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * User class.
 *
 * @author Administrator
 * @since 2025/1/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Schema(title = "用户类")
public class User {
    private Integer id;
    private LocalDateTime create_time;
    private String account;
    private String telephone;
    private String password;
    private String email;
    private DateTime end_login_time;
    private String status;


}
