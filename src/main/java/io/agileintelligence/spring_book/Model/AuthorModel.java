package io.agileintelligence.spring_book.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "authorModel")
public class AuthorModel {
	@Id
	private Integer a_id;
	
	@Field
	private String author;
	
	
	public AuthorModel(Integer a_id, String author) {
        this.a_id = a_id;
        this.author = author;
    }

	
	public Integer getA_id()
	{
		return a_id;
	}
	public void setA_id()
	{
		this.a_id=a_id;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor()
	{
		this.author=author;
	}

}
