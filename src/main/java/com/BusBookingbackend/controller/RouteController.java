package com.BusBookingbackend.controller;


import com.BusBookingbackend.Model.RouteModel;
import com.BusBookingbackend.entity.RouteResponse;
import com.BusBookingbackend.entity.Route;
import com.BusBookingbackend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public RouteResponse createRoute(@RequestBody RouteModel routeModel) {
        RouteResponse routeResponse=routeService.addRoute(routeModel);
        return routeResponse ;
    }

    @PreAuthorize("hasRole('Vendor')")
    @GetMapping("/getallroute")
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}
