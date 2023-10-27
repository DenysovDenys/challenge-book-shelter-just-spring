package bookshelter.dao;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import bookshelter.model.Book;

@Repository
public class ShelterDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Book> getListOfBooks() {
		return em.createQuery("from Book").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBookByName(String bookName) {
		return em.createQuery("FROM Book b WHERE b.bookname LIKE :bookName")
				.setParameter("bookName", bookName)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public void addBook(Book book) {
		em.createNativeQuery("INSERT INTO Book (bookname, dateofbook) VALUES (?, ?)")
				.setParameter(1, book.getBookname())
				.setParameter(2, book.getDateofbook())
				.executeUpdate();
	}
	
}
