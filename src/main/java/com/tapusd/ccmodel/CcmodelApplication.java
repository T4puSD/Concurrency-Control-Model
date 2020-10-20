package com.tapusd.ccmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CcmodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(CcmodelApplication.class, args);
    }

}
