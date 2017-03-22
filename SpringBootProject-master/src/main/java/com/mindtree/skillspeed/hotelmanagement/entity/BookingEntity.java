package com.mindtree.skillspeed.hotelmanagement.entity;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class BookingEntity {
@NotBlank
String cityName;
@NotBlank
String hotelName;
@Min(value=1)
Integer rooms;
@NotBlank
String checkIn;
@NotBlank
String checkOut;
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
public String getHotelName() {
	return hotelName;
}
public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}
public Integer getRooms() {
	return rooms;
}
public void setRooms(Integer rooms) {
	this.rooms = rooms;
}
public String getCheckIn() {
	return checkIn;
}
public void setCheckIn(String checkIn) {
	this.checkIn = checkIn;
}
public String getCheckOut() {
	return checkOut;
}
public void setCheckOut(String checkOut) {
	this.checkOut = checkOut;
}
public BookingEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public BookingEntity(String cityName, String hotelName, Integer rooms, String checkIn, String checkOut) {
	super();
	this.cityName = cityName;
	this.hotelName = hotelName;
	this.rooms = rooms;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
}

}
