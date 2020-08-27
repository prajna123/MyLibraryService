DROP TABLE IF EXISTS Book, Library;

CREATE TABLE Library (
    library_id int NOT NULL AUTO_INCREMENT,
	library_name varchar(64),
	library_address varchar(64),
	PRIMARY KEY (library_id)
);

CREATE TABLE Book (
    book_id int NOT NULL AUTO_INCREMENT,
	library_id int,
    book_name varchar(64),
	author varchar(64),
	publisher varchar(64),
	price int,
	PRIMARY KEY (book_id),
    FOREIGN KEY (library_id) REFERENCES Library(library_id)
);

INSERT INTO Library (library_name, library_address) VALUES
  ('Come And Read', 'Bangalore'),
  ('Read More', 'Bangalore'),
  ('Peace', 'Delhi');
  
INSERT INTO Book (library_id, book_name, author, publisher, price) VALUES
  (1, 'book one', 'author one', 'publisher one', 1000),
  (1, 'book two', 'author two', 'publisher two', 1500),
  (1, 'book three', 'author three', 'publisher two', 500),
  (2, 'book one', 'author one', 'publisher one', 1000),
  (2, 'book two', 'author two', 'publisher two', 1500),
  (3, 'book one', 'author one', 'publisher one', 1000),
  (3, 'book two', 'author two', 'publisher two', 1500),
  (3, 'book four', 'author four', 'publisher four', 500);