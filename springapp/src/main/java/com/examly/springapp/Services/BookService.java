package com.examly.springapp.Services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Book;


@Service
public interface BookService {

	List<Book> addBookbyUserIdAndHallId(long hallId,long userId,double price) throws Exception;
	List<Book> getBookByUserId(long userId);

}