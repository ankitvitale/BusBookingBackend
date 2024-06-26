package com.BusBookingbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BusBookingbackend.entity.Vendor;
import java.util.List;
import java.util.Optional;

@Repository
public interface VendorDao extends JpaRepository<Vendor, String> {
    Optional<Vendor> findByUsername(String username);

    Optional<Vendor> findById(long id);

    @Query("SELECT v FROM Vendor v WHERE v.verification_status = false")
    List<Vendor> findUnverifiedVendors();}
