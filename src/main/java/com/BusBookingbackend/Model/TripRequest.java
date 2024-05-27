package com.BusBookingbackend.Model;
import java.sql.Date;

public class TripRequest {
    private String start;
    private String destination;
    private Date date;

    // Default constructor
    public TripRequest() {}

    // Parameterized constructor
    public TripRequest(String start, String destination, Date date) {
        this.start = start;
        this.destination = destination;
        this.date = date;
    }

    // Getters and setters
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

