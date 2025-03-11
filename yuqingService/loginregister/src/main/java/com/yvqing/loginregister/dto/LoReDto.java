package com.yvqing.loginregister.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LoReDto class.
 *
 * @author Administrator
 * @since 2025/2/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoReDto {
    // Class implementation goes here
    private String account;
    private String telephone;
    private String resp;
    //    jwt认证
    private  String token;
}
