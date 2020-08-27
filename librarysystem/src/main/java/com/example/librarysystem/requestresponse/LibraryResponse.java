package com.example.librarysystem.requestresponse;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.librarysystem.dao.Book;

public class LibraryResponse {

	private int libraryId;

	private String libraryAddress;

	private String libraryName;

	private List<BookResponse> books;

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryAddress() {
		return libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public List<BookResponse> getBooks() {
		return books;
	}

	public void setBooks(List<BookResponse> books) {
		this.books = books;
	}
	
	
}
