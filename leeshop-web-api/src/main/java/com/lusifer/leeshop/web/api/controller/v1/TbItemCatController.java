package com.lusifer.leeshop.web.api.controller.v1;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lusifer.leeshop.domain.TbItemCat;
import com.lusifer.leeshop.service.portal.api.TbItemCatService;
import com.lusifer.leeshop.web.api.dto.BaseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "${rest.path.api.v1}/item/cat")
public class TbItemCatController {

    @Reference(version = "1.0.0")
    private TbItemCatService tbItemCatService;

    @ApiOperation(value = "根据 PID 查询商品分类", notes = "根据 PID 查询商品分类")
    @ApiImplicitParam(name = "pid", value = "商品分类 PID", required = true, dataType = "long", paramType = "path")
    @RequestMapping(value = "pid/{pid}")
    public BaseResult selectByPid(@PathVariable(required = true) long pid) {
        List<TbItemCat> list = tbItemCatService.selectByPid(pid);
        return BaseResult.success(list);
    }
}
