package com.BusBookingbackend.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.BusBookingbackend.dao.VendorDao;
import com.BusBookingbackend.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BusBookingbackend.dao.UserDao;
import com.BusBookingbackend.entity.JwtRequest;
import com.BusBookingbackend.entity.JwtResponse;
import com.BusBookingbackend.entity.User;
import com.BusBookingbackend.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDao userDao;

    @Autowired
    private VendorDao vendorDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String username = jwtRequest.getUsername();
        String password = jwtRequest.getPassword();
        authenticate(username, password);

        UserDetails userDetails = loadUserByUsername(username);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        // Determine if the authenticated entity is a user or a vendor
        User user = userDao.findByUsername(username).orElse(null);
        if (user != null) {
            return new JwtResponse(username, newGeneratedToken);
        } else {
            Vendor vendor = vendorDao.findByUsername(username).orElse(null);
            if (vendor != null) {
                return new JwtResponse(username, newGeneratedToken);
            } else {
                throw new Exception("User or Vendor not found with username: " + username);
            }
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Attempt to find the user
        User user = userDao.findByUsername(username).orElse(null);

        // Attempt to find the vendor if user is not found
        Vendor vendor = vendorDao.findByUsername(username).orElse(null);

        // If both are null, throw exception
        if (user == null && vendor == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        Collection<GrantedAuthority> authorities = new HashSet<>();
        String password;
        if (user != null) {
            user.getRole().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            });
            password = user.getPassword();
        } else {
            vendor.getRole().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            });
            password = vendor.getPassword();
        }

        return new org.springframework.security.core.userdetails.User(username, password, authorities);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}