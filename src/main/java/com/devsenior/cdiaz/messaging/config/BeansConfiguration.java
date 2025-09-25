package com.devsenior.cdiaz.messaging.config;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devsenior.cdiaz.messaging.mapper.UserMapper;

@Configuration
public class BeansConfiguration {

    @Bean
    UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    DateTimeFormatter dateTimeFormatter(){
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    }
}
