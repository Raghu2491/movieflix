package io.egen.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.entity.Movies;
import io.egen.exception.EntityAlreadyExistsException;
import io.egen.exception.EntityNotFoundException;
import io.egen.repository.MoviesRepository;

@Service
public class MoviesServiceImp implements MoviesService {

	@Autowired
	MoviesRepository repository;

	@Override
	public List<Movies> findAll() {
		return repository.findAll();
	}

	@Override
	public Movies findById(String id) {
		Movies existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie with id:" + id + " not found");
		}
		return existing;
	}
	
	@Override
	public List<Movies> findByArguments(Map<String, String> params) {
	
		return repository.findByArguments(params);
	}
	
	@Override
	@Transactional
	public Movies create(Movies movie) {
		Movies existing = repository.findByTitle(movie.getTitle());
		if (existing != null) {
			throw new EntityAlreadyExistsException("Movie Already exists: " + movie.getTitle());
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movies update(String id, Movies emp) {
		Movies existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie with id:" + id + " not found");
		}
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movies existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Movie with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
