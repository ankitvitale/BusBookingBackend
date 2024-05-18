package com.BusBookingbackend.Model;

import java.util.List;

public class RouteModel {
//    private Long id;
    private String origin;
    private String destination;
    private Double distance;
    private List<StopModel> stops;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public List<StopModel> getStops() {
        return stops;
    }

    public RouteModel(String origin, String destination, Double distance, List<StopModel> stops) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.stops = stops;
    }

    public void setStops(List<StopModel> stops) {
        this.stops = stops;
    }
}
