package com.yuqing.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


 //自定义注解，注解式AOP。用于用户在认证服务器的行为日志记录，比如登录登出注册等等。

// 定义注解作用的范围，这里是方法
@Target(ElementType.METHOD)
// 定义注解生命周期，这里是运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface UserOptLogger {
    /**
     * 业务名称
     */
    public String operation() default "";

    /**
     * 日志级别
     *
     * @return
     */
    public LogType level() default LogType.INFO;

    /**
     * 是否将当前日志记录到数据库中
     */
    public boolean save() default true;
}
