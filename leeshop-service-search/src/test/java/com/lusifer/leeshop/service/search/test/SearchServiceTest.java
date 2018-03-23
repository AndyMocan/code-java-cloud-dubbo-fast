package com.lusifer.leeshop.service.search.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lusifer.leeshop.domain.TbItem;
import com.lusifer.leeshop.service.search.mapper.TbItemMapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTest {
    private static final String SOLR_COLLECTION_IK = "ik_core";

    @Autowired
    private SolrClient solrClient;

    @Autowired
    private TbItemMapper tbItemMapper;

    @Test
    public void initSolr() throws IOException, SolrServerException {
        Example example = new Example(TbItem.class);
        PageHelper.startPage(1, 100);
        PageInfo<TbItem> tbItemPageInfo = new PageInfo<>(tbItemMapper.selectByExample(example));
        List<TbItem> list = tbItemPageInfo.getList();
        for (TbItem tbItem : list) {
            SolrInputDocument document = new SolrInputDocument();

            document.addField("id", tbItem.getId());
            document.addField("item_title", tbItem.getTitle());
            document.addField("item_sell_point", tbItem.getSellPoint());
            document.addField("item_price", tbItem.getPrice());

            solrClient.add(SOLR_COLLECTION_IK, document);
            solrClient.commit(SOLR_COLLECTION_IK);
        }
    }

    @Test
    public void querySolr() throws IOException, SolrServerException {
        // 创建查询对象
        SolrQuery solrQuery = new SolrQuery();

        // 设置查询条件
        solrQuery.setQuery("手机");

        // 设置分页条件
        solrQuery.setStart(0);
        solrQuery.setRows(10);

        // 设置默认搜索域
        solrQuery.set("df", "item_keywords");

        // 设置高亮效果
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("item_title");
        solrQuery.setHighlightSimplePre("<span style='color:red;'>");
        solrQuery.setHighlightSimplePost("</span>");

        // 获取查询结果集
        QueryResponse queryResponse = solrClient.query(SOLR_COLLECTION_IK, solrQuery);
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
        for (SolrDocument document : solrDocumentList) {
            List<String> list = highlighting.get(document.get("id")).get("item_title");
            if (list != null && list.size() > 0) {
                System.out.println(list.get(0));
            }
        }
    }

}
