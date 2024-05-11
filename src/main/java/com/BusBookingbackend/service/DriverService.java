package com.BusBookingbackend.service;

import com.BusBookingbackend.dao.DriverDao;
import com.BusBookingbackend.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverDao driverDao;
    public Driver addDriver(Driver driver) {

        return driverDao.save(driver);
    }
}
