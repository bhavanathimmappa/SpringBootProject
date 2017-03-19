package com.mindtree.skillspeed.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;

@Controller
public class HomePageController {
@Autowired 
CityEntityDAO cities;
	@RequestMapping(value="/")
	public String getHomepage(Model m) {
		System.out.println(cities.findAll());
		m.addAttribute("Cities", cities.findAll());
		return "index";
	}
}
