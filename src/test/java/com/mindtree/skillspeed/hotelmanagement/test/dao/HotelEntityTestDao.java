package com.mindtree.skillspeed.hotelmanagement.test.dao;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.HotelEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
import com.mindtree.skillspeed.hotelmanagement.entity.HotelEntity;
import com.mindtree.skillspeed.hotelmanagement.main.HotelManagementSystemApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelManagementSystemApplication.class)
@DataJpaTest
public class HotelEntityTestDao {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private HotelEntityDAO repository;

	@Test
	public void testInsertionOfcitydetails() {
		HotelEntity h = new HotelEntity();
		h.setHotel_id(1);
		h.setHotel_name("MTHotel01");
		h.setHotel_price(700.00);
		h.setRoom_avail(15);
		this.entityManager.merge(h);

		HotelEntity user = this.repository.findOne(1);
		assertThat(user.getHotel_id()).isEqualTo(1);
		assertThat(user.getHotel_name()).isEqualTo("MTHotel01");
		assertThat(user.getHotel_price()).isEqualTo(700.00);
		assertThat(user.getRoom_avail()).isEqualTo(15);
		
		
	}
}

