package com.BusBookingbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BusBookingbackend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

//    @Override
//    Optional<User> findById(Long aLong);

    Optional<User> findByUsername(String username);
}
