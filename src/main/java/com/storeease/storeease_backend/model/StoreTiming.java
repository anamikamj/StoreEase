package com.storeease.storeease_backend.model;

import java.sql.Time;

public class StoreTiming {
    private int id;
    private Time openTime;
    private Time closeTime;

    // Constructor
    public StoreTiming(int id, Time openTime, Time closeTime) {
        this.id = id;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }
}
