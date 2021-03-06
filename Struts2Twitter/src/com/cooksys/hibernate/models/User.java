package com.cooksys.hibernate.models;

// Generated May 1, 2015 11:08:34 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable
{

	private Integer id;
	private String username;
	private String password;
	private Set tweets = new HashSet(0);

	public User()
	{
	}

	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, Set tweets)
	{
		this.username = username;
		this.password = password;
		this.tweets = tweets;
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Set getTweets()
	{
		return this.tweets;
	}

	public void setTweets(Set tweets)
	{
		this.tweets = tweets;
	}

}
