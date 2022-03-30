package com.examly.springapp.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.Services.BookService;
import com.examly.springapp.configuration.BookingConfiguration;
import com.examly.springapp.model.Book;




@RestController
@RequestMapping("user")
public class BookController {
	@Autowired
	BookService bookService;
	@RequestMapping("Book")
  	public ResponseEntity<?> addBookwithHall(@RequestBody HashMap<String,String> addBookRequest) {
		try {
			String keys[] = {"hallId","userId","price"};
			if(BookingConfiguration.validationWithHashMap(keys, addBookRequest)) {
				
			}
			long hallId = Long.parseLong(addBookRequest.get("hallId")); 
			long userId =  Long.parseLong(addBookRequest.get("userId")); 
			double price = Double.parseDouble(addBookRequest.get("price"));
			List<Book> obj = bookService.addBookbyUserIdAndHallId(hallId,userId,price);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(null);
		}
		
   }
   @RequestMapping("bookings")
   public ResponseEntity<?> getBooksByUserId(@RequestBody HashMap<String,String> getBookRequest) {
	 try {
		 String keys[] = {"userId"};
		 if(BookingConfiguration.validationWithHashMap(keys, getBookRequest)) {
		 }
		 List<Book> obj = bookService.getBookByUserId(Long.parseLong(getBookRequest.get("userId")));
		 return ResponseEntity.ok(obj);
	 }catch(Exception e) {
		 return ResponseEntity.badRequest().body(null);
	 }	
}
	
}

