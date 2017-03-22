package com.mindtree.skillspeed.hotelmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="BookingHistory")
public class BookingDatabase {
	@OneToOne(cascade = CascadeType.ALL, optional =false, fetch = FetchType.EAGER, orphanRemoval =true)
	@PrimaryKeyJoinColumn
	
	CityEntity city_name;
	@OneToOne(cascade = CascadeType.ALL, optional =false, fetch = FetchType.EAGER, orphanRemoval =true)
	@PrimaryKeyJoinColumn
	
	HotelEntity hotel_name;
	
	Integer no_rooms;
	String Checkin_date;
	String Checkout_date;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
 
	public CityEntity getCity_name() {
		return city_name;
	}
	public void setCity_name(CityEntity city_name) {
		this.city_name = city_name;
	}
	
	public HotelEntity getHotel_name() {
		return hotel_name;
	}
		 
	public void setHotel_name(HotelEntity hotel_name) {
		this.hotel_name = hotel_name;
	}
	public Integer getNo_rooms() {
		return no_rooms;
	}
	public void setNo_rooms(Integer no_rooms) {
		this.no_rooms = no_rooms;
	}
	public String getCheckin_date() {
		return Checkin_date;
	}
	public void setCheckin_date(String checkin_date) {
		Checkin_date = checkin_date;
	}
	public String getCheckout_date() {
		return Checkout_date;
	}
	public void setCheckout_date(String checkout_date) {
		Checkout_date = checkout_date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	

}
