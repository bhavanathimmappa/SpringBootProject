package com.mindtree.skillspeed.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.HotelEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
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
}
