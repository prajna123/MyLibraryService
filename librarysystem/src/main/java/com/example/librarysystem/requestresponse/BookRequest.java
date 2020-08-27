package com.example.librarysystem.requestresponse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "bookName", "author", "publisher", "price" })
public class BookRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("bookName")
	private String bookName;
	@JsonProperty("author")
	private String author;
	@JsonProperty("publisher")
	private String publisher;
	@JsonProperty("price")
	private Integer price;
	@JsonProperty("libraryId")
	private Integer libraryId;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("bookName")
	public String getBookName() {
		return bookName;
	}

	@JsonProperty("bookName")
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@JsonProperty("author")
	public String getAuthor() {
		return author;
	}

	@JsonProperty("author")
	public void setAuthor(String author) {
		this.author = author;
	}

	@JsonProperty("publisher")
	public String getPublisher() {
		return publisher;
	}

	@JsonProperty("publisher")
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@JsonProperty("price")
	public Integer getPrice() {
		return price;
	}

	@JsonProperty("price")
	public void setPrice(Integer price) {
		this.price = price;
	}

	@JsonProperty("libraryId")
	public Integer getLibraryId() {
		return libraryId;
	}

	@JsonProperty("libraryId")
	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	@Override
	public String toString() {
		return "BookRequest [bookName=" + bookName + ", author=" + author + ", publisher=" + publisher + ", price="
				+ price + ", libraryId=" + libraryId + ", additionalProperties=" + additionalProperties + "]";
	}

	
	

}