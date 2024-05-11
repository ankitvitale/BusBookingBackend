package com.BusBookingbackend.service;

import com.BusBookingbackend.Model.BusModel;
import com.BusBookingbackend.dao.BusDao;
import com.BusBookingbackend.entity.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusService {

    @Autowired
    BusDao busDao;

    //add-Bus
    public Bus addBus(Bus bus) {
        return  busDao.save(bus);
    }

    //updatebus
    public Bus updateBus(Bus bus) {
        return busDao.save(bus);
    }

    //delete
    public void deleteBus(Long id){
        Optional<Bus> bus= busDao.findById(id);
        busDao.delete(bus.get());
    }
}
