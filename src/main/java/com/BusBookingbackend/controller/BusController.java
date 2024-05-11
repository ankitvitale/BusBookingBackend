package com.BusBookingbackend.controller;

import com.BusBookingbackend.Model.BusModel;
import com.BusBookingbackend.entity.Bus;
import com.BusBookingbackend.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BusController {
    @Autowired
    BusService busService;


//    @PreAuthorize("hasRole('Vendor')")
    @PostMapping("/addBus")
    public Bus addBus(@RequestBody Bus bus){

        return busService.addBus(bus);
    }

    @PutMapping("/updateBus/{id}")
    public Bus updateBus(@RequestBody Bus bus){
        return busService.updateBus(bus);
    }
}
