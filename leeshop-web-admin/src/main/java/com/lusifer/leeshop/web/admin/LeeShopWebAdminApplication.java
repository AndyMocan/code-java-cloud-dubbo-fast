package com.lusifer.leeshop.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LeeShopWebAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeeShopWebAdminApplication.class, args);
    }
}
