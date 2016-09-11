package io.egen.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
		@NamedQuery(name = "User.findAll", query = "SELECT e FROM User e ORDER BY e.email ASC"),
		@NamedQuery(name = "User.findUserByEmail", query = "SELECT e FROM User e WHERE e.email=:pEmail") 
})
public class User {

	@Id
	@GeneratedValue(generator = "customUUID")
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	private String id;
	
	private String role;
	private String firstName;
	private String lastName;

	@Column(unique = true)
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}
