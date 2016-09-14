package io.egen.repository;

import java.util.List;

import io.egen.entity.User;

public interface UserRepository {
	
	public User create(User emp);
	public User update(User emp);
	public void delete(User emp);
	public List<User> findAll();
	public User findById(String id);
	public User findByEmail(String email);
}
