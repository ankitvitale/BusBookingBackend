package com.BusBookingbackend.service;

import com.BusBookingbackend.Model.DriverModel;
import com.BusBookingbackend.dao.DriverDao;
import com.BusBookingbackend.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverDao driverDao;
    public Driver addDriver(DriverModel drivermodel) {
       //set current user ->vendor

        Driver driver= new Driver(drivermodel.driver_name, drivermodel.license,drivermodel.address,drivermodel.email,drivermodel.phone_number);
driver.setVerified(false);
        return driverDao.save(driver);
    }
}
