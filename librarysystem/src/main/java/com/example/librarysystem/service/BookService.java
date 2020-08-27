package com.example.librarysystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarysystem.dao.Book;
import com.example.librarysystem.requestresponse.BookRequest;
import com.example.librarysystem.requestresponse.BookResponse;


@Service
public interface BookService {

	public void createBooks(BookRequest bookReq);
	
	public BookResponse getBook(int bookId);

	void updateBooks(BookRequest bookReq, int bookId);

}
