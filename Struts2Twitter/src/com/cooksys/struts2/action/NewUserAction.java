package com.cooksys.struts2.action;

import com.cooksys.hibernate.models.User;
import com.cooksys.struts2.dao.UserDAO;
import com.cooksys.struts2.impl.UserDAOImpl;
import com.cooksys.util.Util;
import com.opensymphony.xwork2.ActionSupport;

public class NewUserAction extends ActionSupport
{
	private String username;
	private String password;
	private UserDAO userDAO = new UserDAOImpl();

	public String execute()
	{
		User newUser = new User();
		if (username != null && password != null)
		{
			newUser.setUsername(username);
			newUser.setPassword(password);
			userDAO.save(newUser);
			return SUCCESS;
		}
		return ERROR;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
