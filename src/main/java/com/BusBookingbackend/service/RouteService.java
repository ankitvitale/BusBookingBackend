package com.BusBookingbackend.service;

import com.BusBookingbackend.dao.RouteDao;
import com.BusBookingbackend.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    RouteDao routeDao;
    public Route addRoute(Route route) {
        return  routeDao.save(route);
    }
    public List<Route> getAllRoutes() {
        return routeDao.findAll();
    }
}
