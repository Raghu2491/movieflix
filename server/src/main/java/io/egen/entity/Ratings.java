package io.egen.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Rating.findRatingAvgByMovieId", query = "select avg(r.value) from Rating r where r.movie.id = :pMovieId"),
	@NamedQuery(name = "Rating.findRatingByUserIdMovieId", query = "select r from Rating r where r.user.id = :pUserId and r.movie.id = :pMovieId")
	
})	
public class Ratings {
	@Id
	@GeneratedValue(generator = "customUUID")
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Movies movie;
	
	private int value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
