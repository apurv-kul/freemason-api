package com.hsbc.solution.model;

public class MapData {

    private String date;

    private String target;

    private long slots;

    private long totalSlots;


    public MapData(String date, String target, long slots, long totalSlots) {
        this.date = date;
        this.target = target;
        this.slots = slots;
        this.totalSlots = totalSlots;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public long getSlots() {
        return slots;
    }

    public void setSlots(long slots) {
        this.slots = slots;
    }

    public long getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(long totalSlots) {
        this.totalSlots = totalSlots;
    }

    @Override
    public String toString() {
        return "MapData{" +
                "date='" + date + '\'' +
                ", target='" + target + '\'' +
                ", slots=" + slots +
                ", totalSlots=" + totalSlots +
                '}';
    }
}
