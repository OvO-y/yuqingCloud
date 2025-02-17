package com.yuqing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient//开启服务发现
@SpringBootApplication
public class DataManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataManageApplication.class,args);
    }
}
