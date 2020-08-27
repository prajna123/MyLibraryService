package com.example.librarysystem.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="book_id")
	private int bookId;

	private String author;

	@Column(name="book_name")
	private String bookName;

	private int price;

	private String publisher;

	//bi-directional many-to-one association to Library
	@ManyToOne
	@JoinColumn(name="library_id")
	private Library library;

	public Book() {
	}

	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Library getLibrary() {
		return this.library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

}