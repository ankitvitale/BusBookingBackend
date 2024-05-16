package com.BusBookingbackend.dao;

import com.BusBookingbackend.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteDao extends JpaRepository<Route, Long> {
}
