package com.BusBookingbackend.entity;

import javax.persistence.*;

@Entity
public class RouteStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stop_sequence;
    private String  stop_name;
    private Double km;
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
    public RouteStop(){}
//    public RouteStop(Long id, Route route, int stop_sequence, String stop_name, Double km) {
//        this.id = id;
//        this.route = route;
//        this.stop_sequence = stop_sequence;
//        this.stop_name = stop_name;
//        this.km = km;
//    }

    public RouteStop(Route route, int i, String name, Double km) {

        this.route = route;
        this.stop_sequence = i;
        this.stop_name = name;
        this.km = km;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getStop_sequence() {
        return stop_sequence;
    }

    public void setStop_sequence(int stop_sequence) {
        this.stop_sequence = stop_sequence;
    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }
}
