package com.mindtree.skillspeed.hotelmanagement.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
import com.mindtree.skillspeed.hotelmanagement.entity.HotelEntity;

@Controller	
public class HotelLandingPageController {
@Autowired
CityEntityDAO dao;
	@RequestMapping(value="/hotellistingpage/{CityName}/{Checkin}/{CheckOut}/{NoOfRooms}")
	public String showHotelList(@PathVariable(value="CityName") String Name,@PathVariable(value="Checkin") String checin,@PathVariable(value="CheckOut") String checkout,@PathVariable(value="NoOfRooms") String rooms,Model m){
			Iterable<CityEntity> en=dao.findAll();
			CityEntity entity= new CityEntity();
			en.forEach(item->{
				if(item.getCityName().equals(Name)){
					entity.setCityName(item.getCityName());
					entity.setId(item.getId());
					entity.setHotelentity(item.getHotelentity());
				}
			});
			List<HotelEntity> hotellist= entity.getHotelentity();
			
			Collections.sort(hotellist,new Comparator<HotelEntity>(){

				@Override
				public int compare(HotelEntity o1, HotelEntity o2) {
					if(o1.getHotel_price()>o2.getHotel_price())
						return 1;
					
					if(o1.getHotel_price()<o2.getHotel_price())
						return -1;
					
					return 0;
				}
				
			});
			m.addAttribute("HotelListing", entity.getHotelentity());
			m.addAttribute("cityName", Name);
			m.addAttribute("checkin", checin);
			m.addAttribute("checkout",checkout);
			m.addAttribute("rooms", rooms);
		return "HotelListingPage";
	}
}
