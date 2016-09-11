package io.egen.service;

import java.util.List;
import java.util.Map;
import io.egen.entity.Comments;

public interface CommentsService {
	
	public Comments create(Map<String, String> params, Comments comment);
	public Comments update(String id, Comments emp);
	public void delete(String id);
	public List<Comments> findByArguments(Map<String, String> params);
	public Comments findById(String id);

}
