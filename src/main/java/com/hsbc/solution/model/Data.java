package com.hsbc.solution.model;

import org.springframework.boot.jackson.JsonComponent;

//import java.io.Serializable;
import java.util.Date;

@JsonComponent
public class Data {

    private String dateTime;
    private String carType;
    private String imeiNumber;

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

    public String getImeiNumber() {
        return imeiNumber;
    }

    public void setImeiNumber(String imeiNumber) {
        this.imeiNumber = imeiNumber;
    }

    @Override
    public String toString() {

        //Data{dateTime='01-01-2024 08:42:00', carType='suv'}
        return "\n{\n" +
                "    \"dateTime\":\"" + dateTime + '\"' +","+
                "    \n    \"carType\":\"" + carType + '\"' +","+
                "    \n    \"imeiNumber\":\"" + imeiNumber + '\"' +
                "\n}";
    }
}
