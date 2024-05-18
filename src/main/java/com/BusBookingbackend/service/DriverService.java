package com.BusBookingbackend.service;

import com.BusBookingbackend.Model.DriverModel;
import com.BusBookingbackend.configuration.JwtRequestFilter;
import com.BusBookingbackend.dao.DriverDao;
import com.BusBookingbackend.dao.VendorDao;
import com.BusBookingbackend.entity.Driver;
import com.BusBookingbackend.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    VendorDao vendorDao;
    @Autowired
    DriverDao driverDao;
    public Driver addDriver(DriverModel drivermodel) {
       //set current user ->vendor

        String currentUser = JwtRequestFilter.CURRENT_USER;
        Vendor vendor= vendorDao.findByUsername(currentUser).get();

       // Driver driver=new Driver();
        //driver1.setVendor(vendor);
        Driver driver= new Driver(drivermodel.driver_name, drivermodel.license,drivermodel.address,drivermodel.email,drivermodel.phone_number);
      driver.setVerified(false);
        driver.setVendor(vendor);
        return driverDao.save(driver);
    }

    public List<Driver> getAllDriver() {
        return driverDao.findAll();
    }

    public List<Driver> tobeVerifiedDriver() {
        return driverDao.findUnverifiedDriver();
    }

    public Driver markVerifiedDriver(Long id) throws Exception {
        String currentUser = JwtRequestFilter.CURRENT_USER;
        Vendor vendor= vendorDao.findByUsername(currentUser).get();
        Optional<Driver> optionalVendor = driverDao.findById(id);
        if (!optionalVendor.isPresent()) {
            throw new Exception("Vendor with ID " + id + " not found");
        }
        Driver dirver = optionalVendor.get();
        dirver.setVerification_status(true);
        dirver.setVendor(vendor);
        driverDao.save(dirver);
        return dirver;
    }

}
