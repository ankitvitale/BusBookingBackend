package com.BusBookingbackend.controller;

import javax.annotation.PostConstruct;

import com.BusBookingbackend.entity.Vendor;
import com.BusBookingbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.BusBookingbackend.entity.Vendor;
import com.BusBookingbackend.service.VenderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenderController {

    @Autowired
    private UserService userService;

    @Autowired
    private  VenderService vendorService;

    @PostConstruct
    public void initRoleAndVendor() {
    	userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewVendor"})
    public Vendor registerNewUser(@RequestBody Vendor vender) {
        return vendorService.registerNewVender(vender);
    }

//    @GetMapping({"/forAdmin"})
//    @PreAuthorize("hasRole('Admin')")
//    public String forAdmin(){
//        return "This URL is only accessible to the admin";
//    }
//
//    @GetMapping({"/forUser"})
//    @PreAuthorize("hasRole('Vender')")
//    public String forVender(){
//        return "This URL is only accessible to the user";
//    }

}
