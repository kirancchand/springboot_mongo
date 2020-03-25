package io.agileintelligence.spring_book.Interface;

import java.util.List;

import io.agileintelligence.spring_book.Model.User;

public interface UserDAL {

	User addNewUser(User user);
	
	List<User> getAllUsers();

	User getUserById(String userId);

	Object getAllUserSettings(String userId);

	String getUserSetting(String userId, String key);

	String addUserSetting(String userId, String key, String value);
}