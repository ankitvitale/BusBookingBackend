package com.BusBookingbackend.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BusBookingbackend.entity.Vendor;

import java.util.Optional;

@Repository
public interface VendorDao extends JpaRepository<Vendor, String> {

	//Optional<Vende\r> findById(String username);
    Optional<Vendor> findByUsername(String username);

}
