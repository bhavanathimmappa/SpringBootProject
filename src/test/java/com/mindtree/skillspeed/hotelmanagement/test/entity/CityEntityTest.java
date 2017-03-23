package com.mindtree.skillspeed.hotelmanagement.test.entity;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
import com.mindtree.skillspeed.hotelmanagement.main.HotelManagementSystemApplication;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelManagementSystemApplication.class)
@DataJpaTest
public class CityEntityTest {

    

    @Autowired
    private CityEntityDAO repository;

    @Test
    public void testExample() throws Exception {
    	CityEntity en= new CityEntity();
    	en.setId(1);
    	en.setCityName("Bengaluru");
    	repository.save(en);
    	CityEntity user=this.repository.findOne(1);
    	assertThat(user.getCityName()).isEqualTo("Bengaluru");
    	assertThat(user.getId()).isEqualTo(1);
    	
    	
    
    }

}
