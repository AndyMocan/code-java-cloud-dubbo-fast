package com.lusifer.leeshop.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.lusifer.leeshop.domain.TbUser;
import com.lusifer.leeshop.service.admin.api.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Reference(version = "1.0.0")
    private TbUserService tbUserService;

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        PageInfo<TbUser> pageInfo = tbUserService.page(1, 10);
        List<TbUser> list = pageInfo.getList();
        for (TbUser tbUser : list) {
            System.out.println("用户名：" + tbUser.getUsername());
        }
        return "main";
    }
}
