package com.examly.springapp.Services;


import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Users;


@Service
public interface UserService {
	Users findByMobile(String mobile) throws Exception;
	Users getUserDetailById(long userId) throws Exception;
	Users signUpUser(HashMap<String,String> signupRequest) throws Exception;
	
}

