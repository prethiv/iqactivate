package com.neilson.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

public class ShoppingInfo {
    private String shopperId;
    private List<Product> shelf;

    // getters and setters

    public String getShopperId() {
        return shopperId;
    }

    public List<Product> getShelf() {
        return shelf;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public void setShelf(List<Product> shelf) {
        this.shelf = shelf;
    }
}

