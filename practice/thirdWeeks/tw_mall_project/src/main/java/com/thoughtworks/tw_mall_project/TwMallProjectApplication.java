package com.thoughtworks.tw_mall_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TwMallProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwMallProjectApplication.class, args);
    }
}
