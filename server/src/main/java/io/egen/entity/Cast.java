package io.egen.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Cast {
	@Id
	@GeneratedValue(generator = "customUUID")
	@GenericGenerator(name = "customUUID", strategy = "uuid2")	
	private String id;
	
	private String cast_role;	
	
	private String actor;

	public String getRole() {
		return cast_role;
	}

	public void setRole(String role) {
		this.cast_role = role;
	}

	public String getName() {
		return actor;
	}

	public void setName(String name) {
		this.actor = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cast [id=" + id + ", cast_role=" + cast_role + ", actor_name=" + actor + "]";
	}
	
}
