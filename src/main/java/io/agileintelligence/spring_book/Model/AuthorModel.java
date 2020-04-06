package io.agileintelligence.spring_book.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "authorModel")
public class AuthorModel {
	@Id
	private Integer _id;
	
	@Field
	private String author;
	
	
	public AuthorModel(Integer _id, String author) {
        this._id = _id;
        this.author = author;
    }

	
	public Integer getA_id()
	{
		return _id;
	}
	public void setA_id()
	{
		this._id=_id;
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
