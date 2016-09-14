package io.egen.service;
import java.util.Map;

import io.egen.entity.Ratings;

public interface RatingsService {

	public double findByArguments(Map<String, String> params) ;
	public Ratings findById(String id);
		public Ratings create(Map<String, String> params,Ratings rating);
	public Ratings update(String id, Ratings emp);
	public void delete(String id);
}
