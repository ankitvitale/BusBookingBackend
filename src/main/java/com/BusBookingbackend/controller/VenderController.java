//package com.BusBookingbackend.controller;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.BusBookingbackend.entity.Vender;
//import com.BusBookingbackend.service.VenderService;
//
//public class VenderController {
//
//    @Autowired
//    private VenderService venderService;
//
//    @PostConstruct
//    public void initRoleAndVernder() {
//    	venderService.initRoleAndVender();
//    }
//
//    @PostMapping({"/registerNewUser"})
//    public Vender registerNewUser(@RequestBody Vender vender) {
//        return venderService.registerNewVender(vender);
//    }
//
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
//
//}
