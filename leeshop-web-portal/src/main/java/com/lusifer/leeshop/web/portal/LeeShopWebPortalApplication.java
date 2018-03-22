package com.lusifer.leeshop.web.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LeeShopWebPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeeShopWebPortalApplication.class, args);
    }
}
