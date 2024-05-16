package com.BusBookingbackend.service;

import com.BusBookingbackend.Model.BusModel;
import com.BusBookingbackend.configuration.JwtRequestFilter;
import com.BusBookingbackend.dao.BusDao;
import com.BusBookingbackend.dao.VendorDao;
import com.BusBookingbackend.entity.Bus;
import com.BusBookingbackend.entity.Vendor;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusService {

 //  private static final Logger logger = (Logger) LoggerFactory.getLogger(BusService.class);
    @Autowired
    BusDao busDao;

    @Autowired
    VendorDao vendorDao;

    //add-Bus
    public Bus addBus(BusModel busModel) {
        String currentUser = JwtRequestFilter.CURRENT_USER;
        Vendor vendor= vendorDao.findByUsername(currentUser).get();

        Bus bus =new Bus();
        bus.setVendor(vendor);

         bus.setBusNumber(busModel.getBus_number());
         bus.setTotalSeats(busModel.getTotal_seats());
         bus.setType(busModel.getType());

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
