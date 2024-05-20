package com.BusBookingbackend.service;

import com.BusBookingbackend.Model.TripModel;
import com.BusBookingbackend.configuration.JwtRequestFilter;
import com.BusBookingbackend.dao.*;
import com.BusBookingbackend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private BusDao busDao;

    @Autowired
    private VendorDao vendorDao;

    @Autowired
    private DriverDao driverDao;

    @Autowired
    private RouteDao routeDao;

    @Autowired
    private TripDao tripDao;

    public Trip addTrip(TripModel tripModel) throws Exception {
       // Optional<Vendor> optionalVendor = vendorDao.findById(vendorId);

        String currentUser = JwtRequestFilter.CURRENT_USER;
        Optional<Vendor> vendor1= vendorDao.findByUsername(currentUser);

        if (vendor1.isPresent()) {
            Vendor vendor = vendor1.get();

            if (!vendor.getVerification_status()) {
                throw new Exception("Unverified vendor: " + vendor);
            }
            Optional<Bus> bus= busDao.findById(tripModel.getBusId());
          //  Bus optionalBus = busDao.findById(tripModel.getBusId()).get();
            Optional<Driver> optionalDriver = driverDao.findById(tripModel.getDriverId());
            Optional<Route> optionalRoute = routeDao.findById(tripModel.getRouteId());

            if (bus.isEmpty()) {
                throw new Exception("No bus present with ID: " + tripModel.getBusId());
            } else if (!optionalDriver.isPresent()) {
                throw new Exception("No driver present with ID: " + tripModel.getDriverId());
            } else if (!optionalRoute.isPresent()) {
                throw new Exception("No route present with ID: " + tripModel.getRouteId());
            } else {
                Driver driver = optionalDriver.get();
                Boolean a= driver.isVerified();
                if (a==false) {
                    throw new Exception("Unverified driver: " + driver);
                }

               // Bus bus = optionalBus.get();
                Route route = optionalRoute.get();
                Trip trip = new Trip(vendor, bus.get(), driver, route, tripModel.getDate(), tripModel.getTime());
                tripDao.save(trip);
                return trip;
            }
        } else {
            throw new Exception("Vendor not found ");
        }
//        Trip trip = new Trip(vendor, bus, driver, route, tripModel.getDate(), tripModel.getTime());
//        tripDao.save(trip);
//        return trip;
    }
}
