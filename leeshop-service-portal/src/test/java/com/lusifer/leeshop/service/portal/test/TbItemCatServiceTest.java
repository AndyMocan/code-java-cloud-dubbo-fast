package com.lusifer.leeshop.service.portal.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lusifer.leeshop.domain.TbItemCat;
import com.lusifer.leeshop.service.portal.api.TbItemCatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TbItemCatServiceTest {

    @Reference(version = "1.0.0")
    private TbItemCatService tbItemCatService;

    @Test
    public void testSelectByPid() {
        List<TbItemCat> list = tbItemCatService.selectByPid(0L);
        for (TbItemCat tbItemCat : list) {
            System.out.println(tbItemCat.getName());
        }
    }
}
