package com.hsbc.solution.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hsbc.solution.model.Data;
import com.hsbc.solution.model.ResponseData;
import com.hsbc.solution.service.ParkingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@RestController
public class ParkingDataController {

    @Autowired
    private ParkingService service;

    private static final Logger log = LoggerFactory.getLogger(ParkingDataController.class);


    @PostMapping(path = "/getParkingData")
    public ResponseData getSlots(@RequestBody Data data) {

        //log.info(data.toString());
        //const myJSON = JSON.stringify(data);
        //log.info("Car type is "+ data.getCarType());
        //JSONObject jsonObject= new JSONObject();
        //log.info("Request is " + jsonObject.toString());
        return service.getSlots(data);
    }



}
