package com.BusBookingbackend.Model;

import java.sql.Time;
import java.sql.Date;

public class TripModel {
    public long id;
    public Long busId;
    public Long driverId;
    public Long routeId;
    public Date date;
    public Time time;
    private EmailMessage emailMessage;

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

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
    public EmailMessage getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(EmailMessage emailMessage) {
        this.emailMessage = emailMessage;
    }
    public long getId() {return id;}

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TripModel{" +
                "busId=" + busId +
                ", driverId=" + driverId +
                ", routeId=" + routeId +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
