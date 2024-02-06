package com.hotelbooking.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HotelBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int bookingId;
	private String guestName;
	private String hotelName;
	private String checkInDate;
	private String checkOutDate;
	private int guestCount;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
	private User user;
}
