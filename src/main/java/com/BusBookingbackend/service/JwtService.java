
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

        //User user = userDao.findById(username).get();
        User user = userDao.findByUsername(username).get();
        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        Vendor vendor = vendorDao.findByUsername(username)
                .orElse(null); // Assume vendor might not exist

        Collection<GrantedAuthority> authorities = new HashSet<>();
        if (user != null) {
            user.getRole().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            });
        }
        if (vendor != null) {
            vendor.getRole
                    ().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
            });
        }

        if (authorities.isEmpty()) {
            throw new UsernameNotFoundException("No roles found for user: " + username);
        }

        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //  User user = userDao.findById(username).get();
//        User user = userDao.findByUsername(username).get();
//
//        if (user != null) {
//            return new org.springframework.security.core.userdetails.User(
//                    user.getUsername(),
//                    user.getPassword(),
//                    getAuthority(user)
//            );
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }

//    private Set getAuthority(User user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        user.getRole().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
//        });
//        return authorities;
//    }

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
