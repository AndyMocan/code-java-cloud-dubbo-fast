package com.lusifer.leeshop.service.portal;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lusifer.leeshop.service.portal.mapper")
public class LeeShopServicePortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeeShopServicePortalApplication.class, args);
        Main.main(args);
    }
}
