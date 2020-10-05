package com.wj.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.wj.springsecurity.mapper")
@SpringBootApplication
public class SpringbootSecurityJspApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityJspApplication.class, args);
    }

}
