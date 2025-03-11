package com.yvqing.loginregister.test;

import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

public class TestJwt {
    String signature = "admin";
    @Test
    public void test() {
        JwtBuilder builder = Jwts.builder();
//        设置token所维持的时间，过了这个时间立即失效
        long expirationTime = System.currentTimeMillis() + 1000 * 60 * 60;
//        拼接它的三个信息
        String token = builder
//                header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
//                payload
                .claim("username","tom")
                .claim("role","admin")
                .setSubject("admin-test")
                .setExpiration(new Date(expirationTime))
                .setId(UUID.randomUUID().toString())
//                签名
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        System.out.println(token);
    }

    @Test
    public void prase() {
        String adtoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE3NDAxMzQxODgsImp0aSI6ImZjMDE0MDcwLTdhMGUtNDA1Mi04Y2ZiLTU5MTQ4Y2VhYTQwNSJ9.75avoyI4uGJTK51f4I5MLdl--DTL6GgULY8BhmlZ-ns";
//        下面这个是之前的立即过期代码，所以会报错
//        String adtoken ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRvbSIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE3NDAxMjk2ODcsImp0aSI6IjFjOWQ3YTY2LTU2YzAtNGUyYy1iZTMxLTkzMWY4MmY5N2ZhOSJ9.Rk5Myle1PRkkmo_zVPqLoExM-j_N0i7LrTvAeVrwPJM";
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJwts = parser.setSigningKey(signature).parseClaimsJws(adtoken);
        Claims claims = claimsJwts.getBody();
        System.out.println(claims.get("username"));
        System.out.println(claims.get("role"));
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getExpiration());
    }
}
