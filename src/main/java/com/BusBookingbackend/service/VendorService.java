package com.BusBookingbackend.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;
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
        Optional<Vendor> vendor1= vendorDao.findByUsername(vendormodel.getUsername());
        if(vendormodel.password.equals(vendormodel.confirm_password)  ){

            if(vendor1.isPresent()){
                throw new RuntimeException("Already Present");

            }

            Vendor vendor = new Vendor();
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
            vendor.setDoc2(vendormodel.getDoc2());

            return vendorDao.save(vendor);
        }
        else throw new RuntimeException("Password not matching");
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public List<Vendor> tobeVerified() {
        return vendorDao.findUnverifiedVendors();
    }

    public Vendor markVerified(Long id) throws Exception {
        Optional<Vendor> optionalVendor = vendorDao.findById(id);
        if (!optionalVendor.isPresent()) {
            throw new Exception("Vendor with ID " + id + " not found");
        }
        Vendor vendor = optionalVendor.get();
        vendor.setVerification_status(true);
        vendorDao.save(vendor);
        return vendor;
    }

}

