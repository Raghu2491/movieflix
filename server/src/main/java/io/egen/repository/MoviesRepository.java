package io.egen.repository;

import java.util.List;
import java.util.Map;

import io.egen.entity.Movies;

public interface MoviesRepository {
	
	public Movies create(Movies emp);
	public Movies update(Movies emp);
	public void delete(Movies emp);
	public Movies findByTitle(String title);
	public List<Movies> findAll();
	public Movies findById(String id);
	public List<Movies> findByArguments(Map<String, String> params);
	
}
