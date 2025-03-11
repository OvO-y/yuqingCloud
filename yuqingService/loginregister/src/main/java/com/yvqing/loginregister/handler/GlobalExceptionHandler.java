package com.yvqing.loginregister.handler;


import com.yvqing.loginregister.dto.ErrorResponseEntity;
import com.yvqing.loginregister.dto.LoReDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//全局异常处理
@ControllerAdvice
public class GlobalExceptionHandler {

//
//    @ExceptionHandler(Exception.class)
//    public ErrorResponseEntity handleGeneralException(Exception ex) {
//        return new ErrorResponseEntity(
//                ex.toString(),
//                ex.getClass().getName(),
//                ex.getStackTrace()
//        );
//    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<LoReDto> handleUserNotFoundException(UserNotFoundException ex) {
        LoReDto errorDto = new LoReDto();
        errorDto.setResp(ex.getMessage()); // 设置错误信息
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto); // 返回 404 和 DTO
    }
}
