package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryStockFeed {
    @JsonProperty("MessageType")
    public String messageType;
    public ArticleStockDetails articleStockDetails;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public ArticleStockDetails getArticleStockDetails() {
        return articleStockDetails;
    }

    public void setArticleStockDetails(ArticleStockDetails articleStockDetails) {
        this.articleStockDetails = articleStockDetails;
    }
}
