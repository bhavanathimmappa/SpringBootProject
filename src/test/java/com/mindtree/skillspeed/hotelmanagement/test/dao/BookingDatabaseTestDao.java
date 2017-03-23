package com.mindtree.skillspeed.hotelmanagement.test.dao;


	import static org.assertj.core.api.Assertions.assertThat;

	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
	import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.skillspeed.hotelmanagement.dao.BookingDatabaseDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.BookingDatabase;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
	import com.mindtree.skillspeed.hotelmanagement.main.HotelManagementSystemApplication;


	@RunWith(SpringRunner.class)
	@SpringBootTest(classes = HotelManagementSystemApplication.class)
	@DataJpaTest
	public class BookingDatabaseTestDao {
		@Autowired
		private TestEntityManager entityManager;
		@Autowired
		private BookingDatabaseDAO repository;

		@Test
		public void testInsertionOfbokkingdetails() {
			BookingDatabase b = new BookingDatabase();
			b.setCheckin_date("03/22/2017");
			b.setCheckout_date("03/23/2017");
			b.setId(1);
			b.setNo_rooms(2);
			this.entityManager.merge(b);

			BookingDatabase user = this.repository.findOne(1);
			assertThat(user.getCheckin_date()).isEqualTo("03/22/2017");
			assertThat(user.getCheckout_date()).isEqualTo("03/23/2017");
			assertThat(user.getId()).isEqualTo(1);
			assertThat(user.getNo_rooms()).isEqualTo(2);
			
			
			
			
		}
	}

