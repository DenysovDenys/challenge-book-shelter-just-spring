package bookshelter.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@Column
	private int id;

	public Book() {
	}

	public Book(String bookname, LocalDate dateofbook) {
		this.bookname = bookname;
		this.dateofbook = dateofbook;
	}

	@Column
	private String bookname;
	@Column
	private LocalDate dateofbook;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public LocalDate getDateofbook() {
		return dateofbook;
	}
	public void setDateofbook(LocalDate dateofbook) {
		this.dateofbook = dateofbook;
	}

}
