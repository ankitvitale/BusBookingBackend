package com.BusBookingbackend.service;


import com.BusBookingbackend.dao.RouteStopDao;
import com.BusBookingbackend.entity.RouteStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteStopeService {

    @Autowired
    RouteStopDao routeStopDao;
    public List<RouteStop> addStop(List<RouteStop> routeStop) {
        return routeStopDao.saveAll(routeStop);
    }


}
