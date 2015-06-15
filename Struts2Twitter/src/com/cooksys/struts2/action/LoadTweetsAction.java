package com.cooksys.struts2.action;

import java.util.List;

import com.cooksys.hibernate.models.Tweet;
import com.opensymphony.xwork2.ActionSupport;

public class LoadTweetsAction extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Tweet> tweets;
	
	public String execute()
	{
		System.out.println("execute called...");
		TweetAction ta = new TweetAction();
		tweets = ta.getTweets();
		return SUCCESS;
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
