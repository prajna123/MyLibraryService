package com.example.librarysystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.librarysystem.dao.Book;
import com.example.librarysystem.dao.Library;
import com.example.librarysystem.repository.LibraryRepository;
import com.example.librarysystem.requestresponse.BookResponse;
import com.example.librarysystem.requestresponse.LibraryResponse;

@Transactional
@Service
public class LibraryServiceImpl implements LibraryService{
	
	@Autowired
	private LibraryRepository  repository; 

	@Override
	public List<Book> getBooks(int libraryId) {
		System.out.println("Service called: "+libraryId);
		List<Book> books = repository.findBookByLibraryId(libraryId);
		return books;
	}
	
	@Override
	public List<LibraryResponse> getLibraries() {
		System.out.println("Inside getLibraries");
		List<Library> libs = repository.findAll();
		List<LibraryResponse> libraryResponses = new ArrayList<>();
		for(Library lib:libs) {
			LibraryResponse libRes = new LibraryResponse();
			libRes.setLibraryId(lib.getLibraryId());
			libRes.setLibraryName(lib.getLibraryName());
			libRes.setLibraryAddress(lib.getLibraryAddress());
			List<BookResponse> bookResponses = new ArrayList<>();
			if(lib.getBooks()!=null) {
				
				for(Book b : lib.getBooks()) {
					BookResponse bookRes = new BookResponse();
					bookRes.setAuthor(b.getAuthor());
					bookRes.setBookId(b.getBookId());
					bookRes.setBookName(b.getBookName());
					bookRes.setPrice(b.getPrice());
					bookRes.setPublisher(b.getPublisher());
					bookResponses.add(bookRes);
				}
			}
			libRes.setBooks(bookResponses);
			libraryResponses.add(libRes);
		}
		return libraryResponses;
	}

}
