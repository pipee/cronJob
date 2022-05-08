package com.equifax.cronjob;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean("restClient")
    public RestTemplate restTemplateRegistry(){
        return new RestTemplate();
    }
}
