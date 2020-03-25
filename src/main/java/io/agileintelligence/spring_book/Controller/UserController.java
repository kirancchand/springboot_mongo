package io.agileintelligence.spring_book.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.introspect.WithMember;

import io.agileintelligence.spring_book.Interface.UserDAL;
import io.agileintelligence.spring_book.Interface.UserRepository;
import io.agileintelligence.spring_book.Model.User;


@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	private final UserDAL userDAL;

	public UserController(UserRepository userRepository, UserDAL userDAL) {
		this.userRepository = userRepository;
		this.userDAL = userDAL;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		
		//with interface
//		return userRepository.save(user);
		
		//with DAL
		return userDAL.addNewUser(user);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		
		//with interface
//		return userRepository.findAll();
		//with DAL
		return userDAL.getAllUsers();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
//		  Optional<User>  for interface
		LOG.info("Getting user with ID: {}.", userId);
		
		//with interface
//		return userRepository.findById(userId);
		//With DAL
		return userDAL.getUserById(userId);
		
	}

	// @RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
	// public Object getAllUserSettings(@PathVariable String userId) {
	// User user = userRepository.findOne(userId);
	// if (user != null) {
	// return user.getUserSettings();
	// } else {
	// return "User not found.";
	// }
	// }

	@RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
	public Object getAllUserSettings(@PathVariable String userId) {
//		Optional<User> user = userRepository.findById(userId);
		User user = userDAL.getUserById(userId);
		if (user != null) {
			return userDAL.getAllUserSettings(userId);
		} else {
			return "User not found.";
		}
	}

	// @RequestMapping(value = "/settings/{userId}/{key}", method =
	// RequestMethod.GET)
	// public String getUserSetting(@PathVariable String userId, @PathVariable
	// String key) {
	// //User user = userRepository.findOne(userId);
	// String setting = userDAL.getUserSetting(userId, key);
	// LOG.info("Setting = "+setting);
	// if (setting != null) {
	// return setting;
	// } else {
	// return "Setting not found.";
	// }
	// }

	@RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
		return userDAL.getUserSetting(userId, key);
	}

}

//package io.agileintelligence.spring_book.Controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import io.agileintelligence.spring_book.Interface.UserInterface;
//import io.agileintelligence.spring_book.Model.UserModel;
//
//@RestController
//@RequestMapping(value="/user")
//public class UserController {
//	private final Logger LOG = LoggerFactory.getLogger(getClass());
//	@Autowired
//	private UserInterface userInterface;
////	
////	public UserController(UserInterface userInterface) {
////		this.userInterface = userInterface;
////	}
//	
//	@GetMapping(value="/home")
//	public String home()
//	{
//		return "hyy";
//	}
//
//	@RequestMapping(value="/create",method = RequestMethod.POST)
//	public UserModel addNewUsers(@RequestBody UserModel user)
//	{
//		LOG.info("saving user");
//		return userInterface.save(user);
//	}
//	
//	@RequestMapping(value="/getall",method = RequestMethod.GET)
//	public List<UserModel> getAll()
//	{
//		LOG.info("Getting user with ID: {}.");
//		return userInterface.findAll();
//	}
//	
//	@RequestMapping(value = "/{u_id}", method = RequestMethod.GET)
//	public Optional<UserModel> getU_id(@PathVariable Integer u_id) {
//		LOG.info("Getting user with ID: {}.", u_id);
//		System.out.println(u_id.toString());
//
//		return userInterface.findById(u_id);
//	}
//	
//
//}
