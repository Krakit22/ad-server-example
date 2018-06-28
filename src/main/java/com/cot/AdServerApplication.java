package com.cot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cot.repository")
public class AdServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdServerApplication.class, args);
    }
}
