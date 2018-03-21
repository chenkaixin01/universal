package com.chenkx.universal.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.chenkx.universal"})
public class UniversalRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversalRestApplication.class, args);
    }
}
