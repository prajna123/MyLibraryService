package com.example.librarysystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarysystem.dao.Book;
import com.example.librarysystem.dao.Library;
import com.example.librarysystem.requestresponse.LibraryResponse;

@Service
public interface LibraryService {

	public List<Book> getBooks(int LibraryId);

	List<LibraryResponse> getLibraries();
}
