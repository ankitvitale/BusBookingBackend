package com.BusBookingbackend.controller;

import com.BusBookingbackend.entity.Driver;
import com.BusBookingbackend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {


    @Autowired
    DriverService driverService;


    @PostMapping("/addDriver")
    public Driver addDriver(@RequestBody Driver driver){
        return driverService.addDriver(driver);
    }




}
