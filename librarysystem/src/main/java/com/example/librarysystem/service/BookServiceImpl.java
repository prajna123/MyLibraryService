package com.example.librarysystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.librarysystem.dao.Book;
import com.example.librarysystem.dao.Library;
import com.example.librarysystem.repository.BookRepository;
import com.example.librarysystem.repository.LibraryRepository;
import com.example.librarysystem.requestresponse.BookRequest;
import com.example.librarysystem.requestresponse.BookResponse;

@Transactional
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository  repository;

	@Override
	public void createBooks(BookRequest bookReq) {
		Book book = new Book();
		book.setBookName(bookReq.getBookName());
		book.setAuthor(bookReq.getAuthor());
		book.setPublisher(bookReq.getPublisher());
		book.setPrice(bookReq.getPrice());
		if(bookReq.getLibraryId()!=null) {
			Library lib = new Library();
			lib.setLibraryId(bookReq.getLibraryId());
		}
		repository.save(book);
		
	}
	
	@Override
	public void updateBooks(BookRequest bookReq, int bookId) {
		Book book = repository.getBookByBookId(bookId);
		if(bookReq.getBookName()!=null) {
			book.setBookName(bookReq.getBookName());
		}
		if(bookReq.getAuthor()!=null) {
			book.setAuthor(bookReq.getAuthor());
		}
		if(bookReq.getPublisher()!=null) {
			book.setPublisher(bookReq.getPublisher());
		}
		if(bookReq.getPrice()!=null) {
			book.setPrice(bookReq.getPrice());
		}
		if(bookReq.getLibraryId()!=null) {
			Library lib = new Library();
			lib.setLibraryId(bookReq.getLibraryId());
		}
		repository.save(book);
		
	}

	@Override
	public BookResponse getBook(int bookId) {
		Book book = repository.getBookByBookId(bookId);
		BookResponse response = new BookResponse();
		response.setBookName(book.getBookName());
		response.setPublisher(book.getPublisher());
		response.setAuthor(book.getAuthor());
		response.setPrice(book.getPrice());
		return response;
	} 
	
	
}
