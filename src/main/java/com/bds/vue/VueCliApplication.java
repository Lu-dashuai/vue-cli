package com.bds.vue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bds.vue.dao")
public class VueCliApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueCliApplication.class, args);
    }

}
