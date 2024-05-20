package com.BusBookingbackend.controller;

import com.BusBookingbackend.Model.DriverModel;
import com.BusBookingbackend.entity.Driver;
import com.BusBookingbackend.entity.Vendor;
import com.BusBookingbackend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    DriverService driverService;

    @PreAuthorize("hasRole('Vendor')")
    @PostMapping("/addDriver")
    public Driver addDriver(@RequestBody DriverModel driver){
        return driverService.addDriver(driver);
    }

    @PreAuthorize("hasRole('Vendor')")
    @GetMapping({"/getAllDriver"})
    public List<Driver> getAllDriver(){
        return driverService.getAllDriver();
    }


    @GetMapping("/tobeVerifiedDriver")
    public List<Driver> tobeVerifiedDriver(){
      return driverService.tobeVerifiedDriver ();
    }

    @PreAuthorize("hasRole('Vendor')")
    @PostMapping("/markVerifiedDriver/{id}")
    public Driver markVerifiedDriver(@PathVariable("id") Long id) throws Exception {
        return driverService.markVerifiedDriver(id);
    }//? not workin

}
