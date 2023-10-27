package testbook;

import java.time.LocalDate;
import java.util.List;

import bookshelter.logic.BaseController;
import bookshelter.model.Book;

public class MainTest {

	public static void main(String[] args) {

		BaseController base = new BaseController();
		List<Book> books = base.getListOfBooks();
		
		for(Book book:books) {
			System.out.println(book.getBookname());
		}

		System.out.println();

		base.addBook(new Book("Harry Potter 2", LocalDate.parse("2004-07-01")));
		books = base.getListOfBooks();

		for(Book book:books) {
			System.out.println(book.getBookname());
		}
	}
}
