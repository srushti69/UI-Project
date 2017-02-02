package io.srushti.movieflex_apii.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery	(name="User.findbyEmail",query="SELECT u FROM User u WHERE u.email=:uEmail")
})
public class User {
	
	@Id
	private String id;
	private String name;
	private String password;
	@Column(unique=true)
	private String email;
	public User(){
		this.id = UUID.randomUUID().toString();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
