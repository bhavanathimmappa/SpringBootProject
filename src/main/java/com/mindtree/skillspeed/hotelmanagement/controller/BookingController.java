package com.mindtree.skillspeed.hotelmanagement.controller;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.skillspeed.hotelmanagement.dao.BookingDatabaseDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.HotelEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.BookingDatabase;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
import com.mindtree.skillspeed.hotelmanagement.entity.HotelEntity;

@Controller
public class BookingController {
	@Autowired
	BookingDatabaseDAO booking;
	@Autowired
	CityEntityDAO cityDAO;
	@Autowired
	HotelEntityDAO hotelDAO;
	@RequestMapping("/booknow")
	public String BookHotels(@RequestParam("city") String city,@RequestParam("hotel") String hotel,@RequestParam("check_in") String check_in,@RequestParam("check_out") String check_out,@RequestParam("rooms") String rooms){
		BookingDatabase book= new BookingDatabase();
		book.setCheckin_date(check_in);
		book.setCheckout_date(check_out);
		Iterable<CityEntity> itr=cityDAO.findAll();
itr.forEach(item->{
	if(item.getCityName().equals(city)){
		book.setCity_name(item);
	}
});
	Iterable<HotelEntity> itr1=hotelDAO.findAll();
		
	itr1.forEach(item->{
		if(item.getHotel_name().equals(hotel)){
			book.setHotel_name(item);
		}
	});
	book.setNo_rooms(Integer.parseInt(rooms));
		booking.save(book);
		return "Success";
		
		
	}
}
