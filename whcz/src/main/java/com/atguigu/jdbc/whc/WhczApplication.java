package com.atguigu.jdbc.whc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.atguigu.jdbc.whc.dao")
@EnableCaching
@SpringBootApplication
public class WhczApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhczApplication.class, args);
    }

}
