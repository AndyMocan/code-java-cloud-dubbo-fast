package com.lusifer.leeshop.service.admin;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lusifer.leeshop.service.admin.mapper")
public class LeeShopServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeeShopServiceAdminApplication.class, args);
        Main.main(args);
    }
}
