package com.lusifer.leeshop.web.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lusifer.leeshop.service.search.api.SearchService;
import com.lusifer.leeshop.service.search.dto.SearchResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "search")
public class SearchController {

    @Reference(version = "1.0.0")
    private SearchService searchService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String search() {
        return "search";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String search(String query, Model model) {
        List<SearchResult> searchResults = searchService.query(query, 1, 10);
        model.addAttribute("searchResults", searchResults);
        return "search";
    }
}
