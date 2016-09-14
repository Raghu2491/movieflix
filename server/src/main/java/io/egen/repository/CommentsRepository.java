package io.egen.repository;

import java.util.List;
import java.util.Map;

import io.egen.entity.Comments;

public interface CommentsRepository {	

	public Comments create(Comments comment);
	public Comments update(Comments emp);
	public void delete(Comments emp);
	public List<Comments> findByArguments(Map<String, String> params);
	public Comments findById(String id);
}
