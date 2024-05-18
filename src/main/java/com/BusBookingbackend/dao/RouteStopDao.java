package com.BusBookingbackend.dao;


import com.BusBookingbackend.entity.RouteStop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteStopDao extends JpaRepository<RouteStop, Long> {
    List<RouteStop> findAllByRouteId(Long routeId);}
