package com.mindtree.skillspeed.hotelmanagement.main;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.HotelEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
import com.mindtree.skillspeed.hotelmanagement.entity.HotelEntity;

@SpringBootApplication(scanBasePackages={"com.mindtree.skillspeed.hotelmanagement"})
@AutoConfigureDataJpa
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"com.mindtree.skillspeed.hotelmanagement.dao"})
@EntityScan(basePackages={"com.mindtree.skillspeed.hotelmanagement.entity"})
public class HotelManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementSystemApplication.class, args);
	}
	@Bean 
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public CommandLineRunner clr(HotelEntityDAO dao,	CityEntityDAO cityentity){
		return (args) -> {
			

			HotelEntity en= new HotelEntity();
			en.setHotel_name("MTHotel4");
			en.setHotel_price(10.00);
			en.setRoom_avail(15);
			dao.save(en);
			CityEntity en1= new CityEntity();
			en1.setCityName("Bengaluru");
			ArrayList<HotelEntity> list12=new ArrayList<HotelEntity>();
			list12.add(en);
			
			en1.setHotelentity(list12);
			
			cityentity.save(en1);
			
		};
	}
}
