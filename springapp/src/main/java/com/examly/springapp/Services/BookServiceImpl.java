package com.examly.springapp.Services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.Repository.BookRepository;
import com.examly.springapp.model.Book;
import com.examly.springapp.model.Hall;


@Service
public class BookServiceImpl implements BookService {

	
	@Autowired
	BookRepository bookRepo;

	@Autowired
	HallService hallService;
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Override
	public List<Book> addBookbyUserIdAndHallId(long hallId, long userId,double price) throws Exception {
		try {
			
			Book obj = new Book();
			obj.setUser_id(userId);
			Hall hall = hallService.getHallById(hallId);
			obj.setHall(hall); 
			obj.setPrice(price);
			bookRepo.save(obj);		
			return this.getBookByUserId(userId);	
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public List<Book> getBookByUserId(long userId) {
		return bookRepo.getCartByuserId(userId);
	}


}
