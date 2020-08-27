package com.example.librarysystem.service;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.librarysystem.dao.Book;
import com.example.librarysystem.dao.Library;
import com.example.librarysystem.repository.LibraryRepository;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(SpringRunner.class)
public class LibrarySeviceImplTest {

	@InjectMocks
	private LibraryServiceImpl libServiceImpl;
	
	@Mock
	LibraryRepository  repository;
	
	@Test
	public void getLibraryList() {
		createRecords();
		Mockito.when(repository.findAll()).thenReturn(createRecords());
		int listSize = libServiceImpl.getLibraries().size();
		assertNotEquals(0, listSize);
	}

	private List<Library> createRecords() {
		List<Library> libs = new ArrayList<Library>();
		Library lib = new Library();
		List<Book> books = new ArrayList<Book>();
		Book b = new Book();
		b.setBookId(100);
		b.setAuthor("auth1");
		b.setBookName("Meditate");
		b.setPrice(100);
		b.setPublisher("pub1");
		books.add(b);
		lib.setLibraryAddress("Bangalore");
		lib.setLibraryId(100);
		lib.setLibraryName("Read and Read");
		lib.setBooks(books);
		libs.add(lib);
		return libs;
	}
	
}
