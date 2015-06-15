package com.cooksys.struts2.action;

import java.util.List;

import com.cooksys.hibernate.models.Tweet;
import com.cooksys.struts2.dao.TweetDAO;
import com.cooksys.struts2.dao.UserDAO;
import com.cooksys.struts2.impl.TweetDAOImpl;
import com.cooksys.struts2.impl.UserDAOImpl;
import com.cooksys.util.Util;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Scoped;

public class TweetAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Integer id = 0;
	private String message;
	private String message2;
	private List<Tweet> tweets;
	private TweetDAO tweetDAO = new TweetDAOImpl();
	private UserDAO userDAO = new UserDAOImpl();
	
	public String execute()
	{
		System.out.println("execute method started...");
		System.out.println("message = " + message);
		Tweet tweet = new Tweet();
		tweet.setMessage(message);
		tweet.setUser(userDAO.getById(Util.getCurrentUserId()));
		
		tweetDAO.save(tweet);
		System.out.println("tweet saved");
		return SUCCESS;
	}
	
	public String deleteTweet()
	{
		System.out.println("deleteTweet action started...");
		System.out.println("message = " + message2);
		
		Tweet tweet = new Tweet();
		List<Tweet> tweets = tweetDAO.getAllTweets();
		
		for(Tweet t : tweets)
		{
			if(t.getMessage().equals(message2))
				tweet = t;
		}
		tweetDAO.delete(tweet);
		
		System.out.println("tweet successfully deleted");
		return SUCCESS;		
	}
	
	public static Integer getId()
	{
		return id;
	}
	public static void setId(Integer id)
	{
		TweetAction.id = id;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public List<Tweet> getTweets()
	{
		return tweetDAO.getAllTweets();
	}
	public void setTweets(List<Tweet> tweets)
	{
		this.tweets = tweets;
	}

	public String getMessage2()
	{
		return message2;
	}

	public void setMessage2(String message2)
	{
		this.message2 = message2;
	}
}
