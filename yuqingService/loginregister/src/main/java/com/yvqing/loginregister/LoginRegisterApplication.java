package com.yvqing.loginregister;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@MapperScan("com.yvqing.loginregister.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class LoginRegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginRegisterApplication.class, args);
    }
    //监听 获取变化值 发送邮件
    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager) {
        return (ApplicationArguments args) -> {
            ConfigService configService = nacosConfigManager.getConfigService();
//            获取配置文件
//            listener为接口，非函数，无法简写，作用是监听
            configService.addListener("service-user.properties", "DEFAULT_GROUP", new Listener() {
                @Override
                public Executor getExecutor() {
                    return Executors.newFixedThreadPool(4);
                }

                //获取变化值
                @Override
                public void receiveConfigInfo(String s) {
                    System.out.println("变化的配置信息"+s);
//                    发送邮件
                    System.out.println("发送邮件......");
                }
            });
            System.out.println("start =========== ");

        };
    }
}
