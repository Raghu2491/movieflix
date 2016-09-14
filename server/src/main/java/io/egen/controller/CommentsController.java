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

import io.egen.entity.Comments;
import io.egen.service.CommentsService;

@RestController
@RequestMapping(path = "comments",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentsController {

	@Autowired
	CommentsService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Comments> findAll(@RequestParam Map<String, String> params) {
		return service.findByArguments(params);
	}

	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public Comments findById(@PathVariable("id") String id) {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comments create(@RequestBody Comments comment, @RequestParam Map<String, String> params) {
		return service.create(params, comment);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comments update(@PathVariable("id") String id, @RequestBody Comments comment) {
		return service.update(id, comment);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}

