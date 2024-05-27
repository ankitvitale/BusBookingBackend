package com.BusBookingbackend.dao;

import com.BusBookingbackend.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
@Repository
public interface TripDao extends JpaRepository<Trip, Long> {
    List<Trip> findAllByDate(Date date);
    List<Trip> findByDriverId(Long id);
    List<Trip> findByBusId(Long id);
}
