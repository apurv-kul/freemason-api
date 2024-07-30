package com.hsbc.solution.model;

import org.springframework.boot.jackson.JsonComponent;

//import java.io.Serializable;
import java.util.Date;

@JsonComponent
public class Data {

    private String dateTime;
    private String carType;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dateTime='" + dateTime + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
