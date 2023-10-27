package bookshelter.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookshelter.logic.BaseController;
import bookshelter.model.Book;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ShelterController {


	@RequestMapping(method = RequestMethod.GET)
	public String doGet(Model model) {
		
		BaseController base = new BaseController();
		List<Book> books = base.getListOfBooks();
		base.closeConnection();
		
		model.addAttribute("books", books);
		
		return "bookshelter";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(@RequestParam String bookName, String dateOfBook, Map<String, Object> model) {
		BaseController base = new BaseController();

		if (bookName.length() > 10) {
			List<Book> books = base.getListOfBooks();
			model.put("message", "Long name");
			model.put("books", books);
		} else {
			List<Book> books = base.getBookByName(bookName);

			if (!books.isEmpty()) {
				model.put("message", "Book already exists!");
				model.put("books", books);
			} else {
				Book book = new Book(bookName, LocalDate.parse(dateOfBook));
				base.addBook(book);
				books = base.getListOfBooks();

				model.put("books", books);
			}
		}

		base.closeConnection();
		return "bookshelter";
	}
}
