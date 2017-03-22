package com.mindtree.skillspeed.hotelmanagement.main;

import java.util.ArrayList;
import java.util.List;

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

@SpringBootApplication(scanBasePackages = { "com.mindtree.skillspeed.hotelmanagement" })
@AutoConfigureDataJpa
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = { "com.mindtree.skillspeed.hotelmanagement.dao" })
@EntityScan(basePackages = { "com.mindtree.skillspeed.hotelmanagement.entity" })
public class HotelManagementSystemApplication {

	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(1);
		integerList.add(2);
		for (Integer i : integerList) {
			System.out.println(i);

		}
		for (int i = 0; i < integerList.size(); i++) {
			System.out.println(integerList.get(i));
		}
		SpringApplication.run(HotelManagementSystemApplication.class, args);
	}

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public CommandLineRunner clr(HotelEntityDAO dao, CityEntityDAO cityentity) {
		return (args) -> {
			
//			HotelEntity en = new HotelEntity();
//			en.setHotel_name("MTHotel4");
//			en.setHotel_price(10.00);
//			en.setRoom_avail(15);
//			CityEntity en1 = new CityEntity();
//			en1.setCityName("Bengaluru");
//			ArrayList<HotelEntity> list12 = new ArrayList<HotelEntity>();
//			list12.add(en);
//			cityentity.save(en1);
//			en.setCityentity(en1);
//			dao.save(en);
//			en1.setHotelentity(list12);
//			//New line
//			
//			HotelEntity mumbaiHotel= new HotelEntity();
//			mumbaiHotel.setHotel_name("MTHotel5");
//			mumbaiHotel.setHotel_price(14.00);
//			mumbaiHotel.setRoom_avail(14);
//			List<HotelEntity> mumbaihotellist= new ArrayList<HotelEntity>();
//			mumbaihotellist.add(mumbaiHotel);
//			CityEntity mumbaicity= new CityEntity();
//			mumbaicity.setHotelentity(mumbaihotellist);
//			mumbaicity.setCityName("Mumbai");
//			cityentity.save(mumbaicity);
//			mumbaiHotel.setCityentity(mumbaicity);
//			dao.save(mumbaiHotel);
//			//new line
//			
//			HotelEntity delhiHotel= new HotelEntity();
//			delhiHotel.setHotel_name("MTHotel6");
//			delhiHotel.setHotel_price(14.00);
//			delhiHotel.setRoom_avail(14);
//			List<HotelEntity> delhiHotellist= new ArrayList<HotelEntity>();
//			mumbaihotellist.add(mumbaiHotel);
//			CityEntity delhicity= new CityEntity();
//			delhicity.setHotelentity(delhiHotellist);
//			delhicity.setCityName("Delhi");
//			cityentity.save(delhicity);
//			delhiHotel.setCityentity(delhicity);
//			dao.save(delhiHotel);
//			

		};
	}
}
