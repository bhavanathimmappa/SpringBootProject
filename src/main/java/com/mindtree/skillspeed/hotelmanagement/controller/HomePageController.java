package com.mindtree.skillspeed.hotelmanagement.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.skillspeed.hotelmanagement.dao.BookingDatabaseDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.CityEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.dao.HotelEntityDAO;
import com.mindtree.skillspeed.hotelmanagement.entity.BookingDatabase;
import com.mindtree.skillspeed.hotelmanagement.entity.BookingEntity;
import com.mindtree.skillspeed.hotelmanagement.entity.CityEntity;
import com.mindtree.skillspeed.hotelmanagement.entity.HotelEntity;

@Controller
public class HomePageController {
	@Autowired
	CityEntityDAO cities;
	@Autowired
	HotelEntityDAO hotels;
	@Autowired
	BookingDatabaseDAO booking;
	// @GetMapping(value="/")
	// public String getHomepage(BookingDatabase bookingObject,Model m) {
	// System.out.println(cities.findAll());
	// m.addAttribute("Cities", cities.findAll());
	// m.addAttribute("Hotels", hotels.findAll());
	// m.addAttribute("bookingObject", bookingObject);
	// return "index";
	// }
	// @PostMapping(value="/")
	// public String checkHomePageValues(@Valid BookingDatabase
	// bookingObject,BindingResult bindingResult){
	// if (bindingResult.hasErrors()) {
	// return "index";
	// }
	//
	// return "redirect:/Success";
	// }

	@GetMapping("/homepage")
	public String showForm(BookingDatabase personForm, Model model) {
		model.addAttribute("personForm", new BookingEntity());
		model.addAttribute("Cities", cities.findAll());
		return "index";
	}

	@PostMapping("/homepage")
	public String checkPersonInfo(@Valid BookingEntity personForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("personForm", new BookingEntity());
			model.addAttribute("Cities", cities.findAll());
			return "index";
		}

		BookingDatabase book = new BookingDatabase();
		book.setCheckin_date(personForm.getCheckIn());
		book.setCheckout_date(personForm.getCheckOut());
		Iterable<CityEntity> itr = cities.findAll();
		itr.forEach(item -> {

			if (item.getCityName().equals(personForm.getCityName())) {
				book.setCity_name(item);
			}
		});
		Iterable<HotelEntity> itr1 = hotels.findAll();

		itr1.forEach(item -> {
			if (item.getHotel_name().equals(personForm.getHotelName())) {
				book.setHotel_name(item);
			}
		});
		book.setNo_rooms(personForm.getRooms());
		booking.save(book);

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date checkInDate = null;
		Date checkOutDate = null;
		try {
			checkInDate = formatter.parse(personForm.getCheckIn());
			checkOutDate = formatter.parse(personForm.getCheckOut());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		;
		formatter.format(checkInDate);
		formatter.format(checkOutDate);

		return "redirect:/hotellistingpage/" + personForm.getCityName() + "/" + checkInDate.getTime() + "/"
				+ checkOutDate.getTime() + "/" + personForm.getRooms();
	}

	@RequestMapping(value = "/Success/{BookingId}")
	public String SuccessPage(Model m, @PathVariable(name = "BookingId") Integer id) {
		System.out.println(id);
		BookingDatabase en = booking.findOne(id);
		String str1 = en.getCheckin_date();
		String str2 = en.getCheckout_date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date checkInDate = null;
		Date checkOutDate = null;
		try {
			checkInDate = formatter.parse(str1);
			checkOutDate = formatter.parse(str2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		;
		formatter.format(checkInDate);
		formatter.format(checkOutDate);
		long d = checkOutDate.getTime() - checkInDate.getTime();
		System.out.println("Days: " + TimeUnit.DAYS.convert(d, TimeUnit.MILLISECONDS));
		int total_days = (int) TimeUnit.DAYS.convert(d, TimeUnit.MILLISECONDS);
		int rooms = en.getNo_rooms();
		double cost = en.getHotel_name().getHotel_price();
		double Total_cost = rooms * cost * total_days;
		m.addAttribute("TotalCost", Total_cost);
		m.addAttribute("BookingID", "GOIBIBO" + System.currentTimeMillis());
		rooms = en.getHotel_name().getRoom_avail() - rooms;

		return "Success";

	}
@RequestMapping(value="/")
public String RenderActualPage() {
	return "HomePage";
	
}
}
