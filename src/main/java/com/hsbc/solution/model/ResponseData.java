package com.hsbc.solution.model;

import org.springframework.boot.jackson.JsonComponent;

import java.io.Serializable;
import java.util.Date;

@JsonComponent
public class ResponseData implements Serializable {

    private long totalSlots;
    private long availableSlots;


   // private long availablePercent;
    private String availablePercent;

/*    public long getAvailablePercent() {
        return availablePercent;
    }

    public void setAvailablePercent(long availablePercent) {
        this.availablePercent = availablePercent;
    }*/



    public String getAvailablePercent() {
        return availablePercent;
    }

    public void setAvailablePercent(String availablePercent) {
        this.availablePercent = availablePercent;
    }







    public long getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(long totalSlots) {
        this.totalSlots = totalSlots;
    }

    public long getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(long availableSlots) {
        this.availableSlots = availableSlots;
    }
}
