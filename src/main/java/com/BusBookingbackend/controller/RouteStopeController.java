package com.BusBookingbackend.controller;


import com.BusBookingbackend.entity.RouteStop;
import com.BusBookingbackend.service.RouteStopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteStopeController {

    @Autowired
    RouteStopeService routeStopeService;

    @PreAuthorize("hasRole('Vendor')")
    @PostMapping("/addStops")
    public List<RouteStop> addRouteStop(@RequestBody List<RouteStop> routeStop){

        return  routeStopeService.addStop(routeStop);

    }
}
