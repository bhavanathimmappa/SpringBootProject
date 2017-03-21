package com.mindtree.skillspeed.hotelmanagement.controller;

import java.util.List;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
cities;
	
	@RequestMapping(value="/hoteloption",method = RequestMethod.GET)
	@ResponseBody
	public String getHotels(@RequestParam("id") String id, Model m) throws JsonProcessingException{
		String HotelEntitys="";
		CityEntity entity=cities.findOne(Integer.parseInt(id));
		List<HotelEntity> list=entity.getHotelentity();
		ObjectMapper mapper = new ObjectMapper();
	//	HotelEntitys+="Abc";
		for(HotelEntity en:list) {
			en.setCityentity(null);
		HotelEntitys+=	mapper.writeValueAsString(en);
	//	HotelEntitys+=",";
		}
	//	HotelEntitys+="]";
		System.out.println(HotelEntitys);
		
		return HotelEntitys;
	}

	
	
}
