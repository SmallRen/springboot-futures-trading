package com.futurestrading;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.futurestrading.mapper")
public class FuturesTradingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuturesTradingApplication.class, args);
    }

}
