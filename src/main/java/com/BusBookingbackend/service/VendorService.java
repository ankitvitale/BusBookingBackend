package com.BusBookingbackend.service;

import java.util.HashSet;
import java.util.Set;

import com.BusBookingbackend.Model.VendorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BusBookingbackend.dao.RoleDao;
import com.BusBookingbackend.dao.VendorDao;
import com.BusBookingbackend.entity.Role;
import com.BusBookingbackend.entity.Vendor;

@Service
public class VendorService {
    @Autowired
    private VendorDao vendorDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    //exception
    public Vendor registerVendor(VendorModel vendormodel) {
        Vendor vendor= vendorDao.findByUsername(vendormodel.getUsername()).get();
        if(vendormodel.password== vendormodel.confirm_password && vendor==null){
            //Vendor vendor = new Vendor();
            Role role = roleDao.findById("Vendor").get();
            Set<Role> venderRoles = new HashSet<>();
            venderRoles.add(role);
            vendor.setRole(venderRoles);
            vendor.setPassword(getEncodedPassword(vendormodel.getPassword()));
            vendor.setAddress(vendormodel.getAddress());
            vendor.setEmail(vendormodel.getEmail());
            vendor.setUsername(vendormodel.getUsername());
            vendor.setOrganization_name(vendormodel.getOrganization_name());
            vendor.setPhone_number(vendormodel.getPhone_number());
            vendor.setVerification_status(false);
            vendor.setDoc1(vendormodel.getDoc1());
            vendor.setDoc2(vendor.getDoc2());

            return vendorDao.save(vendor);
        }
       else throw new RuntimeException("Password not matching");
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}

