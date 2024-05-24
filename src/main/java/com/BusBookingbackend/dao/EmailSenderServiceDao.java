package com.BusBookingbackend.dao;

public interface EmailSenderServiceDao {
    void sendEmail(String to, String subject, String message);
}
