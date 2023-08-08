package com.yassine.BooksAPI.controllers;

import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.REUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yassine.BooksAPI.models.Book;
import com.yassine.BooksAPI.services.BookService;

@Controller
public class bookController {
	// import the bookService
	private final BookService bookServ;
	public bookController(BookService bookServ) {
		this.bookServ = bookServ;
	}
	
	// ==== Display Route =====
	// ShOW ALL
	@RequestMapping("/books")
	public String index(Model model) {
		
	// grab all the books from the service
		List<Book> allDaBooks = bookServ.allBooks();
//		System.out.println(allDaBooks);
		// send to books.jsp the list of books
		model.addAttribute("bookList",allDaBooks);
		return "books.jsp";
			
	}
	// ==== Display Route =====
		// Form
		
		@RequestMapping("/books/new")
		public String bookForm() {
			
			return "create.jsp";
		}
		
		// ==== Action Route =====
		// Create
		@RequestMapping(value = "/books", method = RequestMethod.POST)
		public String create (@RequestParam("title") String title,
							@RequestParam("description") String desc,
							@RequestParam("language") String lang,
							@RequestParam("numberOfPages") int pages) {
			
			Book submittedBook = new Book(title, desc, lang, pages);
			
			Book newlyCreatedbook = bookServ.createBook(submittedBook);
			
			return "redirect:/books";
			
			
	}
		//ONE BOOK SHOW
		@RequestMapping("/books/{id}")
		public String showOne(@PathVariable ("id") Long id , Model model ) {
			
			//fetch the book from the data base
			Book thisBook = bookServ.findBook(id);
			// pass the book to the JSP page
			model.addAttribute("book",thisBook);
			return "oneBook.jsp";
			
		}
		
}
