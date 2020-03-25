package io.agileintelligence.spring_book.Model;

import org.springframework.data.annotation.Id;

public class AuthorModel {
	@Id
	private Integer a_id;
	private String author;
	
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
