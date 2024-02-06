package com.hotelbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.entity.HotelBooking;
import com.hotelbooking.service.HotelIntegration;

@RestController
@RequestMapping("/bookings")
public class HotelController {
	@Autowired
	private HotelIntegration hotelIntegration;

	@PostMapping
	public ResponseEntity<HotelBooking> bookHotel(@RequestBody HotelBooking hotelBooking) {
		HotelBooking booking = hotelIntegration.createHotelBooking(hotelBooking);
		return new ResponseEntity<HotelBooking>(booking, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getAllBookingDetails() {
		List<HotelBooking> allBookings = hotelIntegration.getAllBookings();
		return new ResponseEntity<>(allBookings, HttpStatus.OK);
	}

	@GetMapping("/id")
	public ResponseEntity<HotelBooking> getBookingById(@RequestParam int id) {
		HotelBooking hotelBooking = hotelIntegration.getBookingById(id);
		return new ResponseEntity<HotelBooking>(hotelBooking, HttpStatus.OK);
	}

	@DeleteMapping("/id")
	public ResponseEntity<String> cancelBooking(@RequestParam int bookingId) {
		String cancelledBooking = hotelIntegration.cancelBooking(bookingId);
		return new ResponseEntity<String>(cancelledBooking, HttpStatus.OK);
	}
}
