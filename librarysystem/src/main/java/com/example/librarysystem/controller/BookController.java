package com.example.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarysystem.dao.Book;
import com.example.librarysystem.requestresponse.BookRequest;
import com.example.librarysystem.requestresponse.BookResponse;
import com.example.librarysystem.service.BookServiceImpl;
import com.example.librarysystem.service.LibraryServiceImpl;


@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookServiceImpl  bookServiceImpl;
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity <String> CreateBook(@RequestBody BookRequest request) 
	{
		bookServiceImpl.createBooks(request);
		System.out.println("Book is created");
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity <String> updateBook(@RequestBody BookRequest request, @PathVariable Integer id) 
	{
		bookServiceImpl.updateBooks(request, id);
		System.out.println("Book is updated");
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/details/{id}")
	public BookResponse getBooks(@PathVariable int id) 
	{
		System.out.println("Controller called:"+id);
		BookResponse book = bookServiceImpl.getBook(id);
		System.out.println(book);
		return book;
	}
	
	
	
}

