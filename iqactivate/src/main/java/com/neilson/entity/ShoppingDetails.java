package com.neilson.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "shoppingdetails")
public class ShoppingDetails {

    @Id
    @Column(name = "shopperid")
    private String shopperId;

    @Column(name = "shelfid")
    private String shelfid;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "time_created")
    private int time_created;
    @Column(name = "time_updated")
    private int time_updated;

    public String getShopperId() {
        return shopperId;
    }

    public String getShelfid() {
        return shelfid;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public int getTime_created() {
        return time_created;
    }

    public int getTime_updated() {
        return time_updated;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public void setShelfid(String shelfid) {
        this.shelfid = shelfid;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setTime_created(int time_created) {
        this.time_created = time_created;
    }

    public void setTime_updated(int time_updated) {
        this.time_updated = time_updated;
    }
}
