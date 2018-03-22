package com.lusifer.leeshop.service.redis;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeeShopServiceRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeeShopServiceRedisApplication.class, args);
        Main.main(args);
    }
}
