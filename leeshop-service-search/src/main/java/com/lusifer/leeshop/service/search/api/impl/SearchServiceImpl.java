package com.lusifer.leeshop.service.search.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import com.lusifer.leeshop.service.search.api.SearchService;
import com.lusifer.leeshop.service.search.dto.SearchResult;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service(version = "1.0.0")
public class SearchServiceImpl implements SearchService {
    private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    private static final String SOLR_COLLECTION_IK = "ik_core";

    @Autowired
    private SolrClient solrClient;

    @Override
    public List<SearchResult> query(String query, int pageNum, int pageSize) {
        List<SearchResult> list = Lists.newArrayList();

        // 创建查询对象
        SolrQuery solrQuery = new SolrQuery();

        // 设置查询条件
        solrQuery.setQuery(query);

        // 设置分页条件
        solrQuery.setStart((pageNum - 1) * pageSize);
        solrQuery.setRows(pageSize);

        // 设置默认搜索域
        solrQuery.set("df", "item_keywords");

        // 设置高亮效果
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("item_title");
        solrQuery.setHighlightSimplePre("<span style='color:red;'>");
        solrQuery.setHighlightSimplePost("</span>");

        try {
            // 获取查询结果集
            QueryResponse queryResponse = solrClient.query(SOLR_COLLECTION_IK, solrQuery);
            SolrDocumentList solrDocumentList = queryResponse.getResults();
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
            for (SolrDocument document : solrDocumentList) {
                SearchResult searchResult = new SearchResult();

                searchResult.setId((String) document.get("id"));
                searchResult.setItemTitle((String) document.get("item_title"));
                searchResult.setItemSellPoint((String) document.get("item_sell_point"));
                searchResult.setItemPrice((long) document.get("item_price"));

                List<String> itemTitleHighLightingList = highlighting.get(document.get("id")).get("item_title");
                if (itemTitleHighLightingList != null && itemTitleHighLightingList.size() > 0) {
                    searchResult.setHighlightItemTitle(itemTitleHighLightingList.get(0));
                }

                list.add(searchResult);
            }
        } catch (SolrServerException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return list;
    }
}
