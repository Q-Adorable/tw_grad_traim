package com.thoughtworks.tw_mall_orderserver.tw_mall_orderserver;

import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclint.Entity.gt;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class TwMallOrderserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwMallOrderserverApplication.class, args);
    }
}
