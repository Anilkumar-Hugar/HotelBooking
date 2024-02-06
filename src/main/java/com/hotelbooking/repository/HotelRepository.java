package com.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.entity.HotelBooking;

public interface HotelRepository extends JpaRepository<HotelBooking,Integer> {

}
