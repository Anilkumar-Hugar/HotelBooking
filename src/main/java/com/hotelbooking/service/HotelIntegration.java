package com.hotelbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.HotelBooking;
import com.hotelbooking.repository.HotelRepository;

@Service
public class HotelIntegration {
	@Autowired
	private HotelRepository hotelRepository;

	/**
	 * This method will help the user to create a booking for the hotel
	 * @param hotelBooking
	 * @return It will return the booking details with booking Id
	 */
	public HotelBooking createHotelBooking(HotelBooking hotelBooking) {
		HotelBooking bookingDetails = hotelRepository.save(hotelBooking);
		if (bookingDetails == null) {
			return null;
		}
		return bookingDetails;

	}

	/**
	 * This API will help us to fetch the booking details
	 * @return Returns the list of bookings booked by an user
	 */
	public List<HotelBooking> getAllBookings() {
		List<HotelBooking> listOfHotelBookings = hotelRepository.findAll();
		if (listOfHotelBookings.isEmpty()) {
			return null;
		}
		return listOfHotelBookings;
	}

	/**
	 * This API will help in fetching the particular booking based on its Id
	 * @param id
	 * @return It will return the particular json for the hotel booking
	 */
	public HotelBooking getBookingById(int id) {
		Optional<HotelBooking> booking = hotelRepository.findById(id);
		if (booking.isPresent()) {
			return booking.get();
		}
		return null;
	}

	/**
	 * This API will help to delete the booking by its id
	 * @param bookingId
	 * @return This API will return Message with deleted bookingId
	 */
	public String cancelBooking(int bookingId) {
		Optional<HotelBooking> booking = hotelRepository.findById(bookingId);
		if (booking.isPresent()) {
			hotelRepository.deleteById(booking.get().getBookingId());
			return "Your booking has been deleted with booking Id " + bookingId;
		}
		return "There is no booking with the booking Id " + bookingId;
	}

}
