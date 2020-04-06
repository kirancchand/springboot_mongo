package io.agileintelligence.spring_book.Interface;

import java.util.List;

import io.agileintelligence.spring_book.Model.AuthorBookModel;

public interface AuthorBookDAL {
	
	AuthorBookModel addNewAuthor_Book(AuthorBookModel authorbook);
	
	List<AuthorBookModel> getAll();
//	Object
	AuthorBookModel getByab_id(Integer ab_id);

	List<AuthorBookModel> getAggregagateAll();
}
