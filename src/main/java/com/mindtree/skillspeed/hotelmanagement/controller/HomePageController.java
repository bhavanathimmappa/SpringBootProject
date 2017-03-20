package com.mindtree.skillspeed.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.HotelEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
import com.mindtree.skillspeed.hotelmanagement.entity.HotelEntity;
import com.mindtree.skillspeed.hotelmanagement.entity.JsonObjectMapper;

@Controller
public class HomePageController {
@Autowired 
CityEntityDAO cities;
@Autowired
HotelEntityDAO hotels;
	@RequestMapping(value="/")
	public String getHomepage(Model m) {
		System.out.println(cities.findAll());
		m.addAttribute("Cities", cities.findAll());
		m.addAttribute("Hotels", hotels.findAll());
		return "index";
	}
@RequestMapping(value="/hoteloption",method = RequestMethod.POST)
@ResponseBody
public List<HotelEntity> getHotels(@RequestBody JsonObjectMapper mapper){
	System.out.println("Welcome123");
	CityEntity entity=cities.findOne(mapper.getId());
	return entity.getHotelentity();
}
}
