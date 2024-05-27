package com.BusBookingbackend.service;

import com.BusBookingbackend.Model.TripModel;
import com.BusBookingbackend.configuration.JwtRequestFilter;
import com.BusBookingbackend.dao.*;
import com.BusBookingbackend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private BusService busDao;

    @Autowired
    private VendorDao vendorDao;

    @Autowired
    private DriverDao driverDao;

    @Autowired
    private RouteDao routeDao;
    @Autowired
    private TripDao tripDao;


    //NOT TESTED
    public List<Trip> findTrip(String start, String destination, Date date) {
        List<Trip> TripsByDate = tripDao.findAllByDate(date);
        List<Trip> Trips = new ArrayList<>(); // Initialize as an empty list
        if (TripsByDate != null) { // Check if TripsByDate is not null
            for (Trip t : TripsByDate) {
                Route route = t.getRoute();
                if (route != null && route.getOrigin().equals(start) && route.getDestination().equals(destination)) {
                    Trips.add(t);
                }
            }
        }
        return Trips;
    }

    public Trip addTrip(TripModel tripModel) throws Exception {

        String currentUser = JwtRequestFilter.CURRENT_USER;
        Optional<Vendor> vendor1= vendorDao.findByUsername(currentUser);
       // Optional<Bus> bus= busDao.findById(tripModel.getBusId());
        if (vendor1.isPresent()) {
            Vendor vendor = vendor1.get();

            if (!vendor.getVerification_status()) {
                throw new Exception("Unverified vendor: " + vendor);
            }

            Optional<Driver> optionalDriver = driverDao.findById(tripModel.getDriverId());
            Optional<Route> optionalRoute = routeDao.findById(tripModel.getRouteId());
            //Optional<Bus> optionalBus = busDao.findById(tripModel.getBusId());
            System.out.println("tripModel.getBusId() :: "+tripModel.getBusId());
            Bus bus= busDao.findBus(tripModel.busId);
            if (bus== null) {
                throw new Exception("No bus present with ID: " + tripModel.getBusId());
            }

             if (optionalDriver.isEmpty()) {
                throw new Exception("No driver present with ID: " + tripModel.getDriverId());
            }
             else if (optionalRoute.isEmpty()) {
                throw new Exception("No route present with ID: " + tripModel.getRouteId());
            }
             else {
                Driver driver = optionalDriver.get();
                Boolean a= driver.isVerified();
                if (a==false) {
                    throw new Exception("Unverified driver: " + driver);
                }
                Route route = optionalRoute.get();
                Trip trip = new Trip(vendor, bus, driver, route, tripModel.getDate(), tripModel.getTime());
                 trip.setDate(tripModel.getDate());
                 trip.setTime(tripModel.getTime());
                tripDao.save(trip);
                return trip;
            }
        }
        else {


            throw new Exception("Vendor not found ");
        }

    }
    public void deleteTrip(Long id) {
        tripDao.deleteById(id);
    }

    public Date getDateById(Date date) {
        return date;
    }

    public Time getTimeById(Time time) {
        return time;
    }
}
