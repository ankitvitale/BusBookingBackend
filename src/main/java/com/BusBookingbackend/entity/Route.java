package com.BusBookingbackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Route {
    @Id
    private String route_name;
    private String starting_point;
    private String ending_point;
    private double price_per_km;

}
