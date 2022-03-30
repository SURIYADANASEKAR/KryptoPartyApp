package com.examly.springapp.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.Services.UserService;
import com.examly.springapp.model.Users;




@RestController
public class SignUpController {
	@Autowired
	UserService userservice;

	@RequestMapping("user/signup")
	public ResponseEntity<?> userLogin(@RequestBody HashMap<String, String> signupRequest) {
		try {

			Users user = userservice.signUpUser(signupRequest);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("error while signup");
		}
	}
}
