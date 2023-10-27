package bookshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookshelter.dao.ShelterDAO;
import bookshelter.model.Book;


@Service("ShelterService")
@Transactional
public class ShelterService {

	private ShelterDAO dao;

	@Autowired
	public ShelterService(ShelterDAO dao) {
		this.dao = dao;
	}

	public ShelterService() {
	}

	public List<Book> getListOfBooks() {
		return dao.getListOfBooks();
	}

	public List<Book> getBookByName(String bookName) {
		return dao.getBookByName(bookName);
	}

	public void addBook(Book book) {
		dao.addBook(book);
	}
	
}
