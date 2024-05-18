package com.BusBookingbackend.service;

import com.BusBookingbackend.Model.RouteModel;
import com.BusBookingbackend.entity.RouteResponse;
import com.BusBookingbackend.Model.StopModel;
import com.BusBookingbackend.dao.RouteDao;
import com.BusBookingbackend.dao.RouteStopDao;
import com.BusBookingbackend.entity.Route;
import com.BusBookingbackend.entity.RouteStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    RouteDao routeDao;

    @Autowired
    RouteStopDao routeStopDao;
//    public RouteResponse addRoute(RouteModel routeModel){
//
//            Route route =new Route(routeModel.getOrigin(),routeModel.getDestination(),routeModel.getDistance());
//         routeDao.save(route);
//         Long id= route.getId();
//         int i=1;
//        for (StopModel stop : routeModel.getStops()) {
//            RouteStop routeStop= new RouteStop(route,i++,stop.getName(),stop.getKm());
//            routeStopDao.save(routeStop);
//        }
//
//        RouteResponse routeres= new RouteResponse(route.getOrigin(),route.getDestination(),route.getDistance(),routeStopDao.findAllByRouteId(route.getId()));
//
//    return routeres;
//    }


    public RouteResponse addRoute(RouteModel routeModel){
        try {
            Route route = new Route(routeModel.getOrigin(), routeModel.getDestination(), routeModel.getDistance());
            routeDao.save(route);
            Long id = route.getId();
            int i = 1;
            for (StopModel stop : routeModel.getStops()) {
                RouteStop routeStop = new RouteStop(route, i++, stop.getName(), stop.getKm());
                routeStopDao.save(routeStop);
            }
            return new RouteResponse("Route added successfully"); // Or whatever success message you want to return
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            return new RouteResponse("Error adding route: " + e.getMessage()); // Return an error message
        }
    }


    public List<Route> getAllRoutes() {
        return routeDao.findAll();
    }
}
