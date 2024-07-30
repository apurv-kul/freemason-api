package com.hsbc.solution.controller;

import com.hsbc.solution.model.Data;
import com.hsbc.solution.model.ResponseData;
import com.hsbc.solution.service.ParkingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingDataController {

    @Autowired
    private ParkingService service;

    private static final Logger log = LoggerFactory.getLogger(ParkingDataController.class);


    @PostMapping(path = "/getParkingData")
    public ResponseData getSlots(@RequestBody Data data) {

        return service.getSlots(data);
    }



}
