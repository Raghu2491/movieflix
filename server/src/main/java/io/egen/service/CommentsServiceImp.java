package io.egen.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.entity.Comments;
import io.egen.entity.Movies;
import io.egen.entity.User;
import io.egen.exception.EntityNotFoundException;
import io.egen.repository.CommentsRepository;

@Service
public class CommentsServiceImp implements CommentsService {

	@Autowired
	CommentsRepository repository;
	@Autowired
	UserService userService;
	@Autowired
	MoviesService movieService;
	
	@Override
	public List<Comments> findByArguments(Map<String, String> params) {
		return repository.findByArguments(params);
	}

	@Override
	public Comments findById(String id) {
		Comments existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Comments create(Map<String, String> params, Comments comment) {
		Movies movie = movieService.findById(params.get("movieId"));
		User user = userService.findById(params.get("userId"));
		comment.setUser(user);
		comment.setMovie(movie);
		return repository.create(comment);
	}

	@Override
	@Transactional
	public Comments update(String id, Comments emp) {
		Comments existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment with id:" + id + " not found");
		}
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Comments existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
