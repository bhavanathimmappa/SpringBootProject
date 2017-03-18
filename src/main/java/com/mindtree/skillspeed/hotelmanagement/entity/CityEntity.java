package com.mindtree.skillspeed.hotelmanagement.entity;
import java.util.ArrayList;

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
ArrayList<HotelEntity>hotelentity;
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
//@OneToMany(mappedBy = "city_entity", cascade = CascadeType.ALL)
@OneToMany(targetEntity=HotelEntity.class,mappedBy="city_entity",fetch=FetchType.EAGER)

public ArrayList<HotelEntity> getHotelentity() {
	return hotelentity;
}
public void setHotelentity(ArrayList<HotelEntity> hotelentity) {
	this.hotelentity = hotelentity;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((CityName == null) ? 0 : CityName.hashCode());
	result = prime * result + ((hotelentity == null) ? 0 : hotelentity.hashCode());
	result = prime * result + ((cityentityid == null) ? 0 : cityentityid.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CityEntity other = (CityEntity) obj;
	if (CityName == null) {
		if (other.CityName != null)
			return false;
	} else if (!CityName.equals(other.CityName))
		return false;
	if (hotelentity == null) {
		if (other.hotelentity != null)
			return false;
	} else if (!hotelentity.equals(other.hotelentity))
		return false;
	if (cityentityid == null) {
		if (other.cityentityid != null)
			return false;
	} else if (!cityentityid.equals(other.cityentityid))
		return false;
	return true;
}
@Override
public String toString() {
	return "CityEntity [id=" + cityentityid + ", CityName=" + CityName + ", hotelentity=" + hotelentity + "]";
}


}
