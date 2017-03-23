package com.mindtree.skillspeed.hotelmanagement.test.entity;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.HotelEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
import com.mindtree.skillspeed.hotelmanagement.entity.HotelEntity;
import com.mindtree.skillspeed.hotelmanagement.main.HotelManagementSystemApplication;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelManagementSystemApplication.class)
@DataJpaTest
public class HotelEntityTest {

    @Autowired
    private HotelEntityDAO repository;

    @Test
    public void testExample() throws Exception {
    	HotelEntity en= new HotelEntity();
    	en.setHotel_id(1);
    	en.setHotel_name("ABC");
    	en.setHotel_price(1000.00);
    	en.setRoom_avail(15);
    	repository.save(en);
    	
    	
    	HotelEntity user=this.repository.findOne(1);
    	assertThat(user.getHotel_name()).isEqualTo("ABC");
    	assertThat(user.getHotel_id()).isEqualTo(1);
    	assertThat(user.getHotel_price()).isEqualTo(1000.00);
    	assertThat(user.getRoom_avail()).isEqualTo(15);
    	
    	
    
    }

}


