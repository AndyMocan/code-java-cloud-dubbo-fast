package com.lusifer.leeshop.service.search.api;

import com.lusifer.leeshop.service.search.dto.SearchResult;

import java.util.List;

public interface SearchService {
    public List<SearchResult> query(String query, int pageNum, int pageSize);
}
