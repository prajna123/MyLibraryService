package com.example.librarysystem.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the library database table.
 * 
 */
@Entity
@NamedQuery(name="Library.findAll", query="SELECT l FROM Library l")
public class Library implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="library_id")
	private int libraryId;

	@Column(name="library_address")
	private String libraryAddress;

	@Column(name="library_name")
	private String libraryName;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="library", cascade = CascadeType.ALL,
	        orphanRemoval = true)
	private List<Book> books;

	public Library() {
	}

	public int getLibraryId() {
		return this.libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryAddress() {
		return this.libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}

	public String getLibraryName() {
		return this.libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setLibrary(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setLibrary(null);

		return book;
	}

}