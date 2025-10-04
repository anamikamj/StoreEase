package com.storeease.storeease_backend.model;

import java.sql.Time;

public class StoreTiming {
    private Integer timingId;   // unique ID for the record (nullable before saving)
    private String dayOfWeek;   // e.g. "Monday", "Tuesday"
    private Time openTime;      // opening time
    private Time closeTime;     // closing time
    private Boolean isOpen;     // true if store is open on this day

    // Constructor for fetching from DB
    public StoreTiming(Integer timingId, String dayOfWeek, Time openTime, Time closeTime, Boolean isOpen) {
        this.timingId = timingId;
        this.dayOfWeek = dayOfWeek;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.isOpen = isOpen;
    }

    // Constructor for creating new records (without ID)
    public StoreTiming(String dayOfWeek, Time openTime, Time closeTime, Boolean isOpen) {
        this.dayOfWeek = dayOfWeek;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.isOpen = isOpen;
    }

    // Default constructor (needed by Spring/Jackson)
    public StoreTiming() {
    }

    // Getters and Setters
    public Integer getTimingId() {
        return timingId;
    }

    public void setTimingId(Integer timingId) {
        this.timingId = timingId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
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

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }
}
