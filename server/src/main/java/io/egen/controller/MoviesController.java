package io.egen.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.entity.Movies;
import io.egen.service.MoviesService;

@RestController
@RequestMapping(path = "movies",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MoviesController {

	@Autowired
	MoviesService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Movies> findAll(@RequestParam Map<String, String> params) {
		return service.findByArguments(params);
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public Movies findById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movies create(@RequestBody Movies movie) {

		return service.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movies update(@PathVariable("id") String id, @RequestBody Movies movie) {
		return service.update(id, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}

