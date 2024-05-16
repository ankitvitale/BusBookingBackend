package com.BusBookingbackend.controller;


import com.BusBookingbackend.entity.Route;
import com.BusBookingbackend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteController {

    @Autowired
    private RouteService routeService;


    @PreAuthorize("hasRole('Vendor')")
    @PostMapping("/createroute")
    public Route createRoute(@RequestBody Route route) {
        return routeService.addRoute(route);
    }

    @PreAuthorize("hasRole('Vendor')")
    @GetMapping("/getallroute")
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}
