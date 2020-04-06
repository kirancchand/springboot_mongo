package io.agileintelligence.spring_book.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookModel")
public class BookModel {
	@Id
	private Integer b_id;
	private String book;
	
	
	public BookModel(Integer b_id, String book) {
        this.b_id = b_id;
        this.book = book;
    }
	
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
