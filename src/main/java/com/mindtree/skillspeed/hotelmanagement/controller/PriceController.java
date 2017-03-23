package com.mindtree.skillspeed.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.skillspeed.hotelmanagement.dao.HotelEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.HotelEntity;

@RestController
public class PriceController {

	@Autowired 
	HotelEntityDAO dao;	
	
	@RequestMapping(value="/price/{HotelName}",method = RequestMethod.GET)
	@ResponseBody
	public String getHotels(@PathVariable(value="HotelName") String id) throws JsonProcessingException{
		String HotelEntitys="";
		HotelEntity en=	dao.findOne(Integer.parseInt(id));
		en.setCityentity(null);
		ObjectMapper mapper = new ObjectMapper();
	
		HotelEntitys+=	mapper.writeValueAsString(en);
	
		System.out.println(HotelEntitys);
		
		return HotelEntitys;
	}
}
