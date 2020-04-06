package io.agileintelligence.spring_book.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookModel")
public class BookModel {
	@Id
	private Integer _id;
	private String book;
	
	
	public BookModel(Integer _id, String book) {
        this._id = _id;
        this.book = book;
    }
	
	public Integer getB_id()
	{
		return _id;
	}
	
	public void setB_id()
	{
		this._id=_id;
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
