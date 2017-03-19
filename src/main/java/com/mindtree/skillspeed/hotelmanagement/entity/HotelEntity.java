package com.mindtree.skillspeed.hotelmanagement.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="HotelEntity")
public class HotelEntity  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer Hotel_id;
	String hotel_name;
	Double Hotel_price;
	Integer room_avail;
	@ManyToOne
    @JoinColumn(name="CityEntity_cityentityid")
	CityEntity cityentity;
//	@JoinTable(name = "city_entity",joinColumns= {@JoinColumn(name="hotel_entity_hotel_id")},inverseJoinColumns= {@JoinColumn(name="city_entity_cityetityid")})
	public CityEntity getCityentity() {
		return cityentity;
	}
	public void setCityentity(CityEntity cityentity) {
		this.cityentity = cityentity;
		}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	public Integer getHotel_id() {
		return Hotel_id;
	}
	public void setHotel_id(Integer hotel_id) {
		Hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public Double getHotel_price() {
		return Hotel_price;
	}
	public void setHotel_price(Double hotel_price) {
		Hotel_price = hotel_price;
	}
	public Integer getRoom_avail() {
		return room_avail;
	}
	public void setRoom_avail(Integer room_avail) {
		this.room_avail = room_avail;
	}
	public HotelEntity(Integer hotel_id, String hotel_name, Double hotel_price, Integer room_avail,
			CityEntity cityentity) {
		super();
		Hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		Hotel_price = hotel_price;
		this.room_avail = room_avail;
		this.cityentity = cityentity;
	}
	public HotelEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
