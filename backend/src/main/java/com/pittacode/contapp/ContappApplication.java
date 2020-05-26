package com.pittacode.contapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:joke-configuration.xml")
public class ContappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContappApplication.class, args);
    }
}
