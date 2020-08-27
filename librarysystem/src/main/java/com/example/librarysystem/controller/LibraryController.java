package com.example.librarysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarysystem.dao.Book;
import com.example.librarysystem.dao.Library;
import com.example.librarysystem.requestresponse.LibraryResponse;
import com.example.librarysystem.service.LibraryService;
import com.example.librarysystem.service.LibraryServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/app")
public class LibraryController {
	
	@Qualifier("libraryServiceImpl")
	@Autowired
	private LibraryService  libraryService;
	
	
	@GetMapping("/library/{id}")
	public ResponseEntity <String> findBooks(@PathVariable int id) 
	{
		System.out.println("Controller called:"+id);
		List<Book> books = libraryService.getBooks(id);
		System.out.println(books);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/libraries")
	public List<LibraryResponse> getLibraryList() 
	{
		System.out.println("Calling getLibraryList");
		List<LibraryResponse> libs = libraryService.getLibraries();
		System.out.println(libs);
		return libs;
	}
	
	
}

