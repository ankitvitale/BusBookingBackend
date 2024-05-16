package com.BusBookingbackend.dao;

import com.BusBookingbackend.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripDao extends JpaRepository<Trip, Long> {
}
