package com.BusBookingbackend.dao;

import com.BusBookingbackend.entity.Bus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BusDao extends JpaRepository<Bus, Long> {
}
