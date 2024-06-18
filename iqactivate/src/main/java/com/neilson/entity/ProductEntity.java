package com.neilson.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "product")
public class ProductEntity {

    @Id
    @Column(name = "id")
    private String id;


    @Column(name = "category")
    private String Category;

    @Column(name = "brand")
    private String brand;

    @Column(name = "time_created")
    private int time_created;

    @Column(name = "time_updated")
    private int time_updated;

    @Column(name = "additional_info")
    private String additionalInfo;


    public String getId() {
        return id;
    }

    public String getCategory() {
        return Category;
    }

    public String getBrand() {
        return brand;
    }

    public int getTime_created() {
        return time_created;
    }

    public int getTime_updated() {
        return time_updated;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setTime_created(int time_created) {
        this.time_created = time_created;
    }

    public void setTime_updated(int time_updated) {
        this.time_updated = time_updated;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
