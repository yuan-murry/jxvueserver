package com.gxzh.jxvueserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.gxzh.jxvueserver.mapper"})
public class JxvueserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(JxvueserverApplication.class, args);
    }

}
