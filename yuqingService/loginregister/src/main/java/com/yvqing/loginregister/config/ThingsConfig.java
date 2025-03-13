package com.yvqing.loginregister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ThingsConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
