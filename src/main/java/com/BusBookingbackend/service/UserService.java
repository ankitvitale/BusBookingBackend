package com.BusBookingbackend.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BusBookingbackend.dao.RoleDao;
import com.BusBookingbackend.dao.UserDao;
import com.BusBookingbackend.entity.Role;
import com.BusBookingbackend.entity.User;

@Service
public class UserService {

	
	  @Autowired
	    private UserDao userDao;

	    @Autowired
	    private RoleDao roleDao;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public void initRoleAndUser() {
//
	        Role adminRole = new Role();
	        adminRole.setRoleName("Admin");
	        adminRole.setRoleDescription("Admin role");
			boolean a= roleDao.existsById("Admin");
			if(!a){
				roleDao.save(adminRole);
			}


	        Role userRole = new Role();
	        userRole.setRoleName("User");
	        userRole.setRoleDescription("Default role for newly created record");
	        roleDao.save(userRole);

			Role vendorRole = new Role();
			userRole.setRoleName("Vendor");
			userRole.setRoleDescription("Default role for newly created vendor");
			roleDao.save(userRole);

//
//				Optional<Role> userRoleOptional = roleDao.findById("Admin");
//				if (userRoleOptional.isPresent()) {
//					User adminUser = new User();
//					adminUser.setUsername("admin123");
//					adminUser.setPassword(getEncodedPassword("admin@pass"));
//					adminUser.setName("admin");
//					adminUser.setEmail("admin@gmail.com");
//					adminUser.setContactnumber("708965478512");
//					Set<Role> adminRoles = new HashSet<>();
//					adminRoles.add(adminRole);
//					adminUser.setRole(adminRoles);
//					userDao.save(adminUser);
//				} else {
//					throw new IllegalArgumentException("Role 'User' does not exist in the database.");
//				}
//			User adminUser = new User();
//			Role role = roleDao.findById("Admin").get();
//			Set<Role> userRoles = new HashSet<>();
//			userRoles.add(role);
//			adminUser.setRole(userRoles);
//			adminUser.setUsername("admin123");
//			adminUser.setPassword(getEncodedPassword("admin@pass"));
//			adminUser.setName("admin");
//			adminUser.setEmail("admin@gmail.com");
//			adminUser.setContactnumber("708965478512");
////			return userDao.save(user);
////
////			User adminUser = new User();
////	        adminUser.setUsername("admin123");
////	        adminUser.setPassword(getEncodedPassword("admin@pass"));
////	        adminUser.setName("admin");
////	        adminUser.setEmail("admin@gmail.com");
////	        adminUser.setContactnumber("708965478512");
////	        Set<Role> adminRoles = new HashSet<>();
////	        adminRoles.add(adminRole);
////	        adminUser.setRole(adminRoles);
//	       userDao.save(adminUser);

//	        User user = new User();
//	        user.setUserName("raj123");
//	        user.setUserPassword(getEncodedPassword("raj@123"));
//	        user.setUserFirstName("raj");
//	        user.setUserLastName("sharma");
//	        Set<Role> userRoles = new HashSet<>();
//	        userRoles.add(userRole);
//	        user.setRole(userRoles);
//	        userDao.save(user);
	    }

	    public User registerNewUser(User user) {
	        Role role = roleDao.findById("User").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        user.setRole(userRoles);
	        user.setPassword(getEncodedPassword(user.getPassword()));

	        return userDao.save(user);
	    }

	    public String getEncodedPassword(String password) {
	        return passwordEncoder.encode(password);
	    }

	public User registerAdmin(User user) {
		Role role = roleDao.findById("Admin").get();
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRole(userRoles);
		user.setPassword(getEncodedPassword(user.getPassword()));

		return userDao.save(user);
	}
}
