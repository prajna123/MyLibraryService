package com.example.librarysystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.librarysystem.dao.Book;
import com.example.librarysystem.dao.Library;


public interface LibraryRepository extends JpaRepository<Library, Integer> {

	@Query("select books from Library l where l.libraryId=?1")
	List<Book> findBookByLibraryId(int libraryId);
}
