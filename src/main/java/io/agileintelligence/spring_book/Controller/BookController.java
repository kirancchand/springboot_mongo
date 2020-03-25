package io.agileintelligence.spring_book.Controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.spring_book.Interface.BookInterface;
import io.agileintelligence.spring_book.Model.BookModel;


@RestController
@RequestMapping(value = "/book")
public class BookController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private BookInterface bookInterface;
	
	public BookController(BookInterface bookInterface)
	{
			this.bookInterface = bookInterface;
	}
	
	@GetMapping(value="/home")
	public String home()
	{
		return "hyyy";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public BookModel addNewUsers(@RequestBody BookModel book) {
		LOG.info("Saving user.");
		return bookInterface.save(book);
	}
	
	@RequestMapping(value = "/{b_id}", method = RequestMethod.GET)
	public Optional<BookModel> getUser(@PathVariable Integer b_id) {
		LOG.info("Getting user with ID: {}.", b_id);
		return bookInterface.findById(b_id);
	}
	

}
