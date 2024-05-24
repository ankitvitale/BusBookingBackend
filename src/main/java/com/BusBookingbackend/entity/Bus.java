package com.BusBookingbackend.entity;


import javax.persistence.*;

@Entity
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    public Vendor vendor;

    public String bus_number;
    public int total_seats;
    public String type;


    // Constructors
    public Bus() {
    }

    public Bus(Vendor vendor, String bus_number, int total_seats, String type) {
        this.vendor = vendor;
        this.bus_number = bus_number;
        this.total_seats = total_seats;
        this.type = type;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getBusNumber() {
        return bus_number;
    }

    public void setBusNumber(String bus_number) {
        this.bus_number = bus_number;
    }

    public int getTotalSeats() {
        return total_seats;
    }

    public void setTotalSeats(int total_seats) {
        this.total_seats = total_seats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
