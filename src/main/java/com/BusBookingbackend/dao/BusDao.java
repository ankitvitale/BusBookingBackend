package com.BusBookingbackend.dao;

import com.BusBookingbackend.entity.Bus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusDao extends JpaRepository<Bus, Long> {
    Optional<Bus> findById(Long id);
}
