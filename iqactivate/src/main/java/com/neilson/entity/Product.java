package com.neilson.entity;

public class Product {
    private String productId;
    private double relevancyScore;

    // getters and setters


    public String getProductId() {
        return productId;
    }

    public double getRelevancyScore() {
        return relevancyScore;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setRelevancyScore(double relevancyScore) {
        this.relevancyScore = relevancyScore;
    }
}

