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
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
import com.mindtree.skillspeed.hotelmanagement.main.HotelManagementSystemApplication;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelManagementSystemApplication.class)
@DataJpaTest
public class CityEntityTestDao {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CityEntityDAO repository;

	@Test
	public void testInsertionOfcitydetails() {
		CityEntity c = new CityEntity();
		c.setId(1);
		c.setCityName("Bengaluru");
		this.entityManager.merge(c);

		CityEntity user = this.repository.findOne(1);
		assertThat(user.getId()).isEqualTo(1);
		assertThat(user.getCityName()).isEqualTo("Bengaluru");
		
	}
}


