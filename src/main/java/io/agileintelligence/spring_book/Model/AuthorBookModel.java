package io.agileintelligence.spring_book.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authorbookModel")
public class AuthorBookModel {
	
	@Id
	private Integer ab_id;
	private Integer f_a_id;
	private Integer f_b_id;
	private List<AuthorModel> author;
	private List<BookModel> book;
//	private Map<String, String> user = new HashMap<>();
	
	public AuthorBookModel(Integer ab_id,Integer f_a_id,Integer f_b_id, List<AuthorModel> author,List<BookModel> book) 
	{
		this.ab_id=ab_id;
		this.f_a_id=f_a_id;
		this.f_b_id=f_b_id;
		this.author = author;
		this.book = book;
	   
	}
	 
	 
	
	public Integer getAB_id()
	{
		return ab_id;
	}
	
	public void setAB_id()
	{
		this.ab_id=ab_id;
	}
	
	public Integer getF_a_id()
	{
		return f_a_id;
	}
	
	public void setF_a_id()
	{
		this.f_a_id=f_a_id;
	}
	
	public Integer getF_b_id()
	{
		return f_b_id;
	}
	
	public void setF_b_id()
	{
		this.f_b_id=f_b_id;
	}
	
	public List<AuthorModel> getAuthor()
	{
	     return author;
	}

	public void setAuthor(List<AuthorModel> author)
	{
	     this.author = author;
	}
	
	public List<BookModel> getBook()
	{
	     return book;
	}

	public void setBook(List<BookModel> book)
	{
	     this.book = book;
	}

}
