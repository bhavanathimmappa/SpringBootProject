package com.mindtree.skillspeed.hotelmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.HotelEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
import com.mindtree.skillspeed.hotelmanagement.entity.HotelEntity;

@RestController
public class Hotelcontroller {

	@Autowired
	HotelEntityDAO dao;
	@Autowired
	CityEntityDAO
cityentity;
	
	
	public void performAction(){
		HotelEntity en= new HotelEntity();
		CityEntity en1= new CityEntity();
		en.setHotel_name("MTHotel4");
		en.setHotel_price(10.00);
		en.setRoom_avail(15);
		dao.save(en);
		en1.setCityName("Bengaluru");
		ArrayList<HotelEntity> list12=new ArrayList<HotelEntity>();
		list12.add(en);
	//	en1.setHotelentity(list12);
		
		cityentity.save(en1);
	}
}
