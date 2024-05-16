package com.BusBookingbackend.controller;

import javax.annotation.PostConstruct;

import com.BusBookingbackend.Model.VendorModel;
import com.BusBookingbackend.entity.Vendor;
import com.BusBookingbackend.service.UserService;
import com.BusBookingbackend.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendorController {
    @Autowired
    private UserService userService;

    @Autowired
    private VendorService vendorService;

    @PostConstruct
    public void initRoleAndVendor() {
    	userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewVendor"})
    public Vendor registerNewUser(@RequestBody VendorModel vendormodel) {
        return vendorService.registerVendor(vendormodel);
    }

    @GetMapping({"/tobeVerified"})
    public List<Vendor> tobeVerified(){
        return vendorService.tobeVerified();
    }

    @PostMapping("/markVerified/{id}")
    public Vendor markVerified(@PathVariable("id") Long id) throws Exception {
        return vendorService.markVerified(id);
    }//? not working
}
