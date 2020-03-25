package io.agileintelligence.spring_book.Interface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import io.agileintelligence.spring_book.Model.AuthorBookModel;
import io.agileintelligence.spring_book.Model.User;

@Repository
public class AuthorBookDALImpl implements AuthorBookDAL {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public AuthorBookModel addNewAuthor_Book(AuthorBookModel authorbook) {
		mongoTemplate.save(authorbook);
		// Now, user object will contain the ID as well
		return authorbook;
	}
	
	
//	@Override
//	public List<AuthorBookModel> getAll() {
//		return mongoTemplate.findAll(AuthorBookModel.class);
//		// Now, user object will contain the ID as well	
//	}
	
	@Override
	public AuthorBookModel getByab_id(Integer ab_id) {
	
		Query query = new Query();
		query.addCriteria(Criteria.where("ab_id").is(ab_id));
		return mongoTemplate.findOne(query, AuthorBookModel.class);
	}


	@Override
	public List<AuthorBookModel> getAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(AuthorBookModel.class);
	}
	
	

}
