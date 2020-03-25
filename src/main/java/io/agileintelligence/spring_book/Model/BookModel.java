package io.agileintelligence.spring_book.Model;

import org.springframework.data.annotation.Id;

public class BookModel {
	@Id
	private Integer b_id;
	private String book;
	
	public Integer getB_id()
	{
		return b_id;
	}
	
	public void setB_id()
	{
		this.b_id=b_id;
	}
	
	public String getBook()
	{
		return book;
	}
	
	public void setBook()
	{
		this.book=book;
	}
}
