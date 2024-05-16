package com.BusBookingbackend.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RouteStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Route route;
    private int stop_sequence;
    private String  stop_name;
    private Double km;

}
