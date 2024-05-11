package com.BusBookingbackend.dao;

import com.BusBookingbackend.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverDao extends JpaRepository<Driver, Long> {
}
