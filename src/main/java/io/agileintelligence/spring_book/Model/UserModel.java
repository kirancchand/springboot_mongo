package io.agileintelligence.spring_book.Model;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserModel {
	
	@Id
	@Generated(value = { "" })	
	private Integer u_id;
	private String name;
	private String email;
	private String password;
	
	
	
	
	
	public UserModel() {
		super();
	}
	public UserModel(Integer u_id,String name, String email, String password) {
		super();
		this.u_id = u_id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
