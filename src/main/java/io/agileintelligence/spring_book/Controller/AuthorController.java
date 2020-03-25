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

import io.agileintelligence.spring_book.Interface.AuthorInterface;
import io.agileintelligence.spring_book.Model.AuthorModel;


@RestController
@RequestMapping(value="/author")
public class AuthorController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private AuthorInterface authorInterface;
	@GetMapping(value="/home")
	public String home()
	{
		return "hyy";
	}
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public AuthorModel addNewAuthor(@RequestBody AuthorModel author)
	{
		LOG.info("saving user");
		return authorInterface.save(author);
	}
	
	@RequestMapping(value="/{a_id}",method = RequestMethod.GET)
	public Optional<AuthorModel> getA_id(@PathVariable Integer a_id)
	{
		LOG.info("Getting user with ID: {}.", a_id);
		System.out.println(a_id.toString());

		return authorInterface.findById(a_id);
		
	}
	
	
	

}
