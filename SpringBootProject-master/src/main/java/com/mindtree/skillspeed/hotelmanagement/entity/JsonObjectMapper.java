package com.mindtree.skillspeed.hotelmanagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonObjectMapper {
	@JsonProperty("id")
	Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JsonObjectMapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonObjectMapper(Integer id) {
		super();
		this.id = id;
	}
	
}
