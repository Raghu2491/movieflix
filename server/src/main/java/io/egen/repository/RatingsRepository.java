package io.egen.repository;

import java.util.List;
import java.util.Map;

import io.egen.entity.Ratings;

public interface RatingsRepository {	
	
	public Ratings create(Ratings emp);
	public Ratings update(Ratings emp);
	public void delete(Ratings emp);
	public double findByArguments(Map<String, String> params);
	public Ratings findById(String id);
	public List<Ratings> findByUserIdMovieId(String userId, String movieId);
}
