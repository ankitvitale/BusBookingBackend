//package com.BusBookingbackend.service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.BusBookingbackend.dao.RoleDao;
//import com.BusBookingbackend.dao.VenderDao;
//import com.BusBookingbackend.entity.Role;
//import com.BusBookingbackend.entity.Vender;
//
//@Service
//public class VenderService {
//
//	
//
//    @Autowired
//    private VenderDao venderDao;
//
//    @Autowired
//    private RoleDao roleDao;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public void initRoleAndVender() {
//
//        Role adminRole = new Role();
//        adminRole.setRoleName("Admin");
//        adminRole.setRoleDescription("Admin role");
//        roleDao.save(adminRole);
//
//        Role VenderRole = new Role();
//        VenderRole.setRoleName("Vender");
//        VenderRole.setRoleDescription("Default role for newly created record");
//        roleDao.save(VenderRole);
//        
//        Vender adminVender =new Vender();
//        adminVender.setUsername("admin123");
//        adminVender.setPassword(getEncodedPassword("admin@pass"));
//        adminVender.setConfirom_password(getEncodedPassword("admin@pass"));
//        adminVender.setEmail("admin@gmail.com");
//        adminVender.setMobile_no("7769962336");
//        adminVender.setAddress("nagpur");
//        adminVender.setOrganization_name("xyx");
//        adminVender.setDoc1(null);
//        Set<Role> VenderRoles = new HashSet<>();
//        VenderRoles.add(VenderRole);
//        adminVender.setRole(VenderRoles);
//        venderDao.save(adminVender);
//
////        Vender adminUser = new Vender();
////        adminUser.setUserName("admin123");
////        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
////        adminUser.setUserFirstName("admin");
////        adminUser.setUserLastName("admin");
////        Set<Role> adminRoles = new HashSet<>();
////        adminRoles.add(adminRole);
////        adminUser.setRole(adminRoles);
////        userDao.save(adminUser);
//
////        User user = new User();
////        user.setUserName("raj123");
////        user.setUserPassword(getEncodedPassword("raj@123"));
////        user.setUserFirstName("raj");
////        user.setUserLastName("sharma");
////        Set<Role> userRoles = new HashSet<>();
////        userRoles.add(userRole);
////        user.setRole(userRoles);
////        userDao.save(user);
//    }
//
//    public Vender registerNewVender(Vender vender) {
//        Role role = roleDao.findById("Vender").get();
//        Set<Role> venderRoles = new HashSet<>();
//        venderRoles.add(role);
//        vender.setRole(venderRoles);
//        vender.setConfirom_password(getEncodedPassword(vender.getConfirom_password()));
//
//        return venderDao.save(vender);
//    }
//
//    public String getEncodedPassword(String password) {
//        return passwordEncoder.encode(password);
//    }
//}
//
