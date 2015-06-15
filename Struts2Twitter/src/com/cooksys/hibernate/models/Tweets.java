package com.cooksys.hibernate.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Tweets 
{
	@XmlElement
	private List<Tweet> tweets;

	public List<Tweet> getTweets()
	{
		return tweets;
	}

	public void setTweets(List<Tweet> tweets)
	{
		this.tweets = tweets;
	}
	
	
}
