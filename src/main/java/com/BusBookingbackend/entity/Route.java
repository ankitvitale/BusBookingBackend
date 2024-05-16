package com.BusBookingbackend.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private int distance;

    @ElementCollection
    private Map<Integer,String> stops;
    public Route(){}
    public Route(Long id, String origin, String destination, int distance, Map<Integer, String> stops) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.stops = stops;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Map<Integer, String> getStops() {
        return stops;
    }

    public void setStops(Map<Integer, String> stops) {
        this.stops = stops;
    }
}