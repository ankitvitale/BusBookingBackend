package com.BusBookingbackend.Model;

public class BusModel {
    public String bus_number;
    public int total_seats;
    public String type;

    public BusModel(String bus_number, int total_seats, String type) {
        this.bus_number = bus_number;
        this.total_seats = total_seats;
        this.type = type;
    }

    public String getBus_number() {
        return bus_number;
    }

    public void setBus_number(String bus_number) {
        this.bus_number = bus_number;
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
