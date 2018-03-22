package com.lusifer.leeshop.web.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lusifer.leeshop.domain.TbItemCat;
import com.lusifer.leeshop.service.portal.api.TbItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Reference(version = "1.0.0")
    private TbItemCatService tbItemCatService;

    @RequestMapping(value = {"", "index"})
    public String main(Model model) {
        List<TbItemCat> list = tbItemCatService.selectByPid(0L);
        model.addAttribute("tbItemCats", list);
        return "main";
    }
}
