package io.egen.service;

import java.util.List;
import java.util.Map;

import io.egen.entity.Movies;

public interface MoviesService {

	public List<Movies> findAll();
	public Movies findById(String id);	
	public List<Movies> findByArguments(Map<String, String> params);
	public Movies create(Movies emp);
	public Movies update(String id, Movies emp);
	public void delete(String id);
}
