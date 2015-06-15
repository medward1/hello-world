package com.cooksys.struts2.dao;

import java.util.List;

import com.cooksys.hibernate.models.Tweet;
import com.cooksys.hibernate.models.User;

public interface TweetDAO
{
	public List<Tweet> getAllTweets();
	public List<Tweet> getByUser(User user);
	public void save(Tweet tweet);
	public void delete(Tweet tweet);
}
