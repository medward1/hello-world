package com.cooksys.struts2.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cooksys.hibernate.models.Tweet;
import com.cooksys.hibernate.models.User;
import com.cooksys.struts2.dao.TweetDAO;
import com.cooksys.struts2.dao.UserDAO;
import com.cooksys.struts2.impl.TweetDAOImpl;
import com.cooksys.struts2.impl.UserDAOImpl;
import com.cooksys.util.Util;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
	private String username;
	private String password;
	private List<Tweet> tweets;
	private UserDAO userDAO = new UserDAOImpl();
	private TweetDAO tweetDAO = new TweetDAOImpl();
	
	public void validate()
	{
		System.out.println("validate method started");
		if(StringUtils.isEmpty(username))
			addFieldError("username", "Username required!");
		if(StringUtils.isEmpty(password))
			addFieldError("password", "Password required!");
	}
	public String execute()
	{
		System.out.println("execute method started");
		User user = userDAO.getByUsername(username);
		if(user != null && user.getPassword().equals(password))
		{
			System.out.println("login successful");
			Util.setCurrentUserId(user.getId());
			Util.setCurrentUsername(user.getUsername());
			setTweets(tweetDAO.getByUser(user));
			return "success";
		}
		System.out.println("login failed");
		return "error";
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
	public List<Tweet> getTweets()
	{
		return tweets;
	}
	public void setTweets(List<Tweet> tweets)
	{
		this.tweets = tweets;
	}
	

}
