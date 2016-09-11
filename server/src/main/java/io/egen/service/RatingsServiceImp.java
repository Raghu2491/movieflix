package io.egen.service;

import java.util.List;
import java.util.Map;

import io.egen.entity.Movies;
import io.egen.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.Ratings;
import io.egen.exception.EntityAlreadyExistsException;
import io.egen.exception.EntityNotFoundException;
import io.egen.repository.RatingsRepository;

@Service
public class RatingsServiceImp implements RatingsService {

	@Autowired
	RatingsRepository repository;
	@Autowired
	UserService userService;   
	@Autowired
	MoviesService movieService; 
	
	@Override
	public double findByArguments(Map<String, String> params) {
		return repository.findByArguments(params);
	}

	@Override
	public Ratings findById(String id) {
		Ratings existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Rating with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Ratings create(Map<String, String> params,Ratings rating) {
		List<Ratings> existing = repository.findByUserIdMovieId(params.get("userId"),params.get("movieId"));
		if (existing.size() != 0) {
			throw new EntityAlreadyExistsException("Rating already created: for user:" + params.get("userId") + " movie: "+params.get("movieId"));
		}
		Movies movie = movieService.findById(params.get("movieId"));
		User user = userService.findById(params.get("userId"));
		rating.setUser(user);
		rating.setMovie(movie);
		return repository.create(rating);
	}

	@Override
	@Transactional
	public Ratings update(String id, Ratings emp) {
		Ratings existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Rating with id:" + id + " not found");
		}
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Ratings existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Rating with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
