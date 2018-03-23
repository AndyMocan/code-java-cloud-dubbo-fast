package com.lusifer.leeshop.service.search.dto;

import java.io.Serializable;

public class SearchResult implements Serializable {
    private String id;
    private String itemTitle;
    private String itemSellPoint;
    private long itemPrice;

    private String highlightItemTitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemSellPoint() {
        return itemSellPoint;
    }

    public void setItemSellPoint(String itemSellPoint) {
        this.itemSellPoint = itemSellPoint;
    }

    public long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getHighlightItemTitle() {
        return highlightItemTitle;
    }

    public void setHighlightItemTitle(String highlightItemTitle) {
        this.highlightItemTitle = highlightItemTitle;
    }
}
