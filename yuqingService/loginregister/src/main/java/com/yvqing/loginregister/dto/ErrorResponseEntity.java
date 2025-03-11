package com.yvqing.loginregister.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//返回异常实体类
@AllArgsConstructor
@Data
public class ErrorResponseEntity {
    private String message;

    private String errorName;

    private StackTraceElement[] stackTrace ;
}
