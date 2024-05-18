package com.BusBookingbackend.entity;

import com.BusBookingbackend.entity.RouteStop;

import java.util.List;

public class RouteResponse {
    //    private Long id;
    private String origin;
    private String destination;
    private Double distance;
    private List<RouteStop> stops;


    public RouteResponse(String origin, String destination, Double distance, List<RouteStop> stops) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.stops = stops;
    }


    public RouteResponse(String routeAddedSuccessfully) {
    }
}

