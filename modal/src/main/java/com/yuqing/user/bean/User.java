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
    private  Integer account;
    private  String telephone;
    private  String password;
    private  String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateTime getEnd_login_time() {
        return end_login_time;
    }

    public void setEnd_login_time(DateTime end_login_time) {
        this.end_login_time = end_login_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private  DateTime end_login_time;
    private  String status;
}
