package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.Services.HallService;
import com.examly.springapp.model.Company;
import com.examly.springapp.model.Hall;
import com.examly.springapp.model.Users;



@RestController
@RequestMapping("user")
public class HallController {
	@Autowired
	HallService hallService;

	@RequestMapping("getAllHall")
	public List<Hall> getAllHall() {
		return hallService.getAllHall();
	}

	@RequestMapping("dashboard")
	public List<Company> getAllCompany() {
		return hallService.getAllCompany();
	}

	@RequestMapping("Halls")
	public List<Hall> getHallByCompany(@RequestBody HashMap<String, String> request) {
		String admin_id = request.get("ad_id");
		return hallService.getHallByCompany(admin_id);
	}

	@RequestMapping("profile")
	public Users getProfileById(@RequestParam Long userId) throws Exception {
		return hallService.getProfileById(userId);
	}

	@PutMapping("editProfile")
	public Users editProfile(@RequestBody Users user) {
		return hallService.editProfile(user);
	}
}
