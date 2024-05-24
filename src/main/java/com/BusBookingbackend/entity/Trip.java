package com.BusBookingbackend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private  Bus bus;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public Trip(Vendor vendor, Bus bus, Driver driver, Route route, Date date, Time time) {
        this.id = id;
        this.vendor = vendor;
        this.bus = bus;
        this.driver = driver;
        this.route = route;
        this.date = date;
        this.time = time;
    }

    private Date date;

    private Time time;
    public Trip(){}

    public Trip(Bus bus, Driver driver, Route route, java.util.Date date, Time time) {
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
