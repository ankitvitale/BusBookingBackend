package com.BusBookingbackend.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BusBookingbackend.entity.Vendor;

@Repository
public interface VenderDao extends JpaRepository<Vendor, String> {

	//Optional<Vender> findById(String username);

}
