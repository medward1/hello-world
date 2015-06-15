package com.cooksys.struts2.dao;

import com.cooksys.hibernate.models.User;

public interface UserDAO
{
	public User getById(Integer id);
	public User getByUsername(String username);
	public void save(User userToSave);
	public void delete(User userToDelete);
}
