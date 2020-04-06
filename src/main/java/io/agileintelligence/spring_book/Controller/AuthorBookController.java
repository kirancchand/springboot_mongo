package io.agileintelligence.spring_book.Controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.spring_book.Interface.AuthorBookDAL;
import io.agileintelligence.spring_book.Interface.AuthorBookInterface;
import io.agileintelligence.spring_book.Interface.UserDAL;
import io.agileintelligence.spring_book.Interface.UserRepository;
import io.agileintelligence.spring_book.Model.AuthorBookModel;

@RestController
@RequestMapping(value="/authorbook")
public class AuthorBookController {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	private AuthorBookInterface authorbookInterface;
	private final AuthorBookDAL authorbookDAL;
	
	public AuthorBookController(AuthorBookInterface authorbookInterface, AuthorBookDAL authorbookDAL) {
		this.authorbookInterface = authorbookInterface;
		this.authorbookDAL = authorbookDAL;
	}
	
	@GetMapping(value="/home")
	public String home()
	{
		return "hyy";
	}
	
	
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public AuthorBookModel addNewAuthor_Book(@RequestBody AuthorBookModel authorbook)
	{
		LOG.info("saving user");
//		return authorbookInterface.save(authorbook);
		return authorbookDAL.addNewAuthor_Book(authorbook);
	}
	
//	Object
	@RequestMapping(value = "/{ab_id}", method = RequestMethod.GET)
	public AuthorBookModel getByab_id(@PathVariable Integer ab_id) {
		LOG.info("Getting user with ID: {}.", ab_id);
		System.out.println(ab_id.toString());
		
//		Object aObject=authorbookInterface.findById(ab_id);
//		return aObject;
		return authorbookDAL.getByab_id(ab_id);
	}
	
	@RequestMapping(value="/getall",method = RequestMethod.GET)
	public List<AuthorBookModel> getAll()
	{
		LOG.info("Get all User");
//		return authorbookInterface.findAll();
		return authorbookDAL.getAll();
	}
	
	@RequestMapping(value="/getaggregateall",method = RequestMethod.GET)
	public List<AuthorBookModel> getAggregagateAll()
	{
		LOG.info("Get all aggregate User");
//		return authorbookInterface.findAll();
		return authorbookDAL.getAggregagateAll();
	}
	

}
