package com.example.librarysystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.librarysystem.dao.Book;
import com.example.librarysystem.dao.Library;


public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("select b from Book b where b.bookId=?1")
	Book getBookByBookId(int bookId);
	
	@Query("select b from Book b where b.bookName=?1")
	List<Book> getBookByBookName(String bookName);
}
