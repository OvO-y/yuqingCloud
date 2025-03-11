package com.yvqing.loginregister.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    private static long expirationTime = System.currentTimeMillis() + 1000 * 60 * 60;
    private static String signature = "admin";

    public static String createToken() {
        JwtBuilder builder = Jwts.builder();
//        设置token所维持的时间，过了这个时间立即失效
//        注意这里的时间是一个小时，后面要及时更改时间太短不适应
        long expirationTime = System.currentTimeMillis() + 1000 * 60 * 60;
//        拼接它的三个信息
        String token = builder
//                header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
//                payload
                .claim("username", "tom")
                .claim("role", "admin")
                .setSubject("admin-test")
                .setExpiration(new Date(expirationTime))
                .setId(UUID.randomUUID().toString())
//                签名
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        System.out.println(token);
        return token;
    }
}
