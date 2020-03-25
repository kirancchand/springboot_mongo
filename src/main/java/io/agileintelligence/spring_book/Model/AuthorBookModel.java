package io.agileintelligence.spring_book.Model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class AuthorBookModel {
	
	@Id
	private Integer ab_id;
	private Integer f_a_id;
	private Integer f_b_id;
//	private Map<String, String> user = new HashMap<>();
	
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

}
