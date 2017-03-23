package com.mindtree.skillspeed.hotelmanagement.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.skillspeed.hotelmanagement.dao.BookingDatabaseDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.HotelEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.BookingDatabase;
import com.mindtree.skillspeed.hotelmanagement.entity.HotelEntity;

@Controller
public class BookingController {
	@Autowired
	BookingDatabaseDAO booking;
	@Autowired
	CityEntityDAO cityDAO;
	@Autowired
	HotelEntityDAO hotelDAONew;

	@RequestMapping("/bookit/{CityName}/{HotelName}/{checkin}/{checkout}/{rooms}")
public String BookHotels(@PathVariable(name="CityName") String cityName,@PathVariable(name="HotelName")String HotelName,@PathVariable(value="checkin") String checin,@PathVariable(value="checkout") String checkout,@PathVariable(value="rooms") String rooms,Model m ){	
		Iterable<HotelEntity> en2= hotelDAONew.findAll();
		BookingDatabase book= new BookingDatabase();
		en2.forEach(item->{
			if(item.getHotel_name().equals(HotelName)){
				book.setHotel_name(item);
				book.setCity_name(item.getCityentity());
			}
		});
		
		
		Date chkOut=new Date(Long.parseLong(checkout));
		Date chkIn= new Date(Long.parseLong(checin));
		System.out.println(chkIn.toString());
		book.setCheckin_date(chkIn.toString());
		book.setCheckout_date(chkOut.toString());
		book.setNo_rooms(Integer.parseInt(rooms));
		booking.save(book);
		
		
		
	   long d= Long.parseLong(checkout) - Long.parseLong(checin);
	    System.out.println ("Days: " + TimeUnit.DAYS.convert(d, TimeUnit.MILLISECONDS));
	    int total_days= (int) TimeUnit.DAYS.convert(d, TimeUnit.MILLISECONDS);
		int roomsin =Integer.parseInt(rooms);
		double cost = book.getHotel_name().getHotel_price();
		double Total_cost= roomsin*cost * total_days ;
		m.addAttribute("TotalCost", Total_cost);
		m.addAttribute("BookingID", "GOIBIBO"+System.currentTimeMillis());
		
		return "Success";
		
	
	}
}
