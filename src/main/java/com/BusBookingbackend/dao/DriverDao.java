package com.BusBookingbackend.dao;

import com.BusBookingbackend.entity.Driver;
import com.BusBookingbackend.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverDao extends JpaRepository<Driver, Long> {

    @Query("SELECT v FROM Driver v WHERE v.verified = false")
    List<Driver> findUnverifiedDriver();

    Optional<Driver> findById(Long id);
}
