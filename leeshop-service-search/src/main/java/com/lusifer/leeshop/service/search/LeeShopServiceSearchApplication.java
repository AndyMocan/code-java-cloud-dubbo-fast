package com.lusifer.leeshop.service.search;

import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lusifer.leeshop.service.search.mapper")
public class LeeShopServiceSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeeShopServiceSearchApplication.class, args);
        Main.main(args);
    }
}
