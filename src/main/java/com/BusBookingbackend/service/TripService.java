package com.BusBookingbackend.service;

import com.BusBookingbackend.Model.TripModel;
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

    public Trip addTrip(TripModel tripModel, Long vendorId) throws Exception {
        Optional<Vendor> optionalVendor = vendorDao.findById(vendorId);

        if (optionalVendor.isPresent()) {
            Vendor vendor = optionalVendor.get();

            if (!vendor.getVerification_status()) {
                throw new Exception("Unverified vendor: " + vendor);
            }

            Optional<Bus> optionalBus = busDao.findById(tripModel.getBusId());
            Optional<Driver> optionalDriver = driverDao.findById(tripModel.getDriverId());
            Optional<Route> optionalRoute = routeDao.findById(tripModel.getRouteId());

            if (!optionalBus.isPresent()) {
                throw new Exception("No bus present with ID: " + tripModel.getBusId());
            } else if (!optionalDriver.isPresent()) {
                throw new Exception("No driver present with ID: " + tripModel.getDriverId());
            } else if (!optionalRoute.isPresent()) {
                throw new Exception("No route present with ID: " + tripModel.getRouteId());
            } else {
                Driver driver = optionalDriver.get();
                if (!driver.isVerified()) {
                    throw new Exception("Unverified driver: " + driver);
                }

                Bus bus = optionalBus.get();
                Route route = optionalRoute.get();
                Trip trip = new Trip(vendor, bus, driver, route, tripModel.getDate(), tripModel.getTime());
                tripDao.save(trip);
                return trip;
            }
        } else {
            throw new Exception("Vendor not found with ID: " + vendorId);
        }
    }
}
