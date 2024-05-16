package com.BusBookingbackend.controller;

import com.BusBookingbackend.Model.TripModel;
import com.BusBookingbackend.entity.Bus;
import com.BusBookingbackend.entity.Trip;
import com.BusBookingbackend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TripController {

    @Autowired
    private TripService tripService;
    @PreAuthorize("hasRole('Vendor')")
    @PostMapping("/addTrip/{id}")
    public Trip addBus(@PathVariable("id") Long id, @RequestBody TripModel tripModel) throws Exception{

        return tripService.addTrip(tripModel,id);
    }
}
