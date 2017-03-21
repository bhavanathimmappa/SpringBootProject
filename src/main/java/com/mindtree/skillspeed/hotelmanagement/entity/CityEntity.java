package com.mindtree.skillspeed.hotelmanagement.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="CityEntity")
public class CityEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer cityentityid;
String CityName;
@OneToMany(targetEntity=HotelEntity.class,mappedBy="cityentity", fetch=FetchType.EAGER)
List<HotelEntity> hotelentity;
public Integer getId() {
	return cityentityid;
}
public void setId(Integer id) {
	this.cityentityid = id;
}
public String getCityName() {
	return CityName;
}
public void setCityName(String cityName) {
	CityName = cityName;
}



public List<HotelEntity> getHotelentity() {
	return hotelentity;
}
public void setHotelentity(List<HotelEntity> hotelentity) {
	this.hotelentity = hotelentity;
}
public CityEntity(Integer cityentityid, String cityName, List<HotelEntity> hotelentity) {
	super();
	this.cityentityid = cityentityid;
	CityName = cityName;
	this.hotelentity = hotelentity;
}
public CityEntity() {
	super();
	// TODO Auto-generated constructor stub
}
//@Override
//public String toString() {
//	return "CityEntity [cityentityid=" + cityentityid + ", CityName=" + CityName + ", hotelentity=" + hotelentity + "]";
//}


}
