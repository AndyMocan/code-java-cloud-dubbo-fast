package com.lusifer.leeshop.web.api.controller.v1;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lusifer.leeshop.service.search.api.SearchService;
import com.lusifer.leeshop.web.api.dto.BaseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${rest.path.api.v1}/search")
public class SearchController {
    @Reference(version = "1.0.0")
    private SearchService searchService;

    @ApiOperation(value = "搜索关键字", notes = "搜索关键字")
    @ApiImplicitParam(name = "query", value = "关键字", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "keywords/{query}", method = RequestMethod.GET)
    public BaseResult search(@PathVariable(required = true) String query) {
        return BaseResult.success(searchService.query(query, 1, 10));
    }
}
