package com.BusBookingbackend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private Double distance;

//    @OneToMany(mappedBy = "route")
//    private List<RouteStop> routeStops;


    public Route(){}
    public Route( String origin, String destination, Double distance) {
        //this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        //this.routeStops = routeStops;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

//    public List<RouteStop> getRouteStops() {
//        return routeStops;
//    }
//
//    public void setRouteStops(List<RouteStop> routeStops) {
//        this.routeStops = routeStops;
//    }
}