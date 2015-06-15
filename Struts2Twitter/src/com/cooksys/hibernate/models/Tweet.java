package com.cooksys.hibernate.models;

// Generated May 1, 2015 11:08:34 AM by Hibernate Tools 3.4.0.CR1

/**
 * Tweet generated by hbm2java
 */
public class Tweet implements java.io.Serializable
{

	private Integer id;
	private User user;
	private String message;

	public Tweet()
	{
	}

	public Tweet(User user, String message)
	{
		this.user = user;
		this.message = message;
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public User getUser()
	{
		return this.user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getMessage()
	{
		return this.message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

}
