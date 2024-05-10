package com.BusBookingbackend.controller;

import com.BusBookingbackend.entity.User;
import com.BusBookingbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BusBookingbackend.entity.JwtRequest;
import com.BusBookingbackend.entity.JwtResponse;
import com.BusBookingbackend.service.JwtService;

@RestController

public class JwtController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }

    @PostMapping({"/registerAdmin"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerAdmin(user);
    }

}
