package com.neilson.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "shelf")
public class ShelfEntity {

    @Id
    @Column(name="id")
    private String id;

    @Column(name = "shelfid")
    private String shelfid;

    @Column(name = "productid")
    private String productid;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name="score")
    private String score;

    @Column(name = "time_created")
    private int time_created;

    @Column(name = "time_updated")
    private int time_updated;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getShelfid() {
        return shelfid;
    }

    public String getProductid() {
        return productid;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public String getScore() {
        return score;
    }

    public int getTime_created() {
        return time_created;
    }

    public int getTime_updated() {
        return time_updated;
    }

    public void setShelfid(String shelfid) {
        this.shelfid = shelfid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setTime_created(int time_created) {
        this.time_created = time_created;
    }

    public void setTime_updated(int time_updated) {
        this.time_updated = time_updated;
    }
}
