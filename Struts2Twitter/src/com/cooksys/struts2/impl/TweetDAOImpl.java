package com.cooksys.struts2.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cooksys.hibernate.models.Tweet;
import com.cooksys.hibernate.models.User;
import com.cooksys.struts2.dao.TweetDAO;

public class TweetDAOImpl implements TweetDAO
{
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;
	
	@Override
	public List<Tweet> getAllTweets()
	{
		System.out.println("getting saved tweets...");
		Configuration config = new Configuration();
		config.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		String hql = "FROM Tweet";
		Query q = session.createQuery(hql);
		List<Tweet> tweets = q.list();
		session.close();
		/*
		System.out.println("getting saved tweets...");
		File file = new File("C:\\Users\\FT22\\workspace\\tweets.xml");
		try
		{
			file.createNewFile();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		Tweets tweets = new Tweets();
		JAXBContext context;
		
		System.out.println("unmarshalling from xml file...");
		try
		{
			context = JAXBContext.newInstance(Tweets.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			tweets = (Tweets) unmarshaller.unmarshal(file);

		} catch (JAXBException e)
		{
			System.out.println("unmarshal failed");
			e.printStackTrace();
		}*/

		return tweets;
	}

	@Override
	public void save(Tweet tweet)
	{
		System.out.println("saving tweet...");
		Configuration config = new Configuration();
		config.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(tweet);
		session.getTransaction().commit();
		/*
		List<Tweet> tweetList = getTweets();
		tweetList.add(tweet);

		Tweets tweets = new Tweets();
		tweets.setTweets(tweetList);
		
		File file = new File("C:\\Users\\FT22\\workspace\\tweets.xml");
		System.out.println("marshalling tweets...");
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Tweets.class);
			Marshaller marshaller = jaxbContext.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(tweets, file);
			marshaller.marshal(tweets, System.out);
		} catch (JAXBException e)
		{
			System.out.println("marshall failed");
			e.printStackTrace();
		}*/
	}

	@Override
	public void delete(Tweet tweet)
	{
		System.out.println("deleting tweet...");
		Configuration config = new Configuration();
		config.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(tweet);
		session.getTransaction().commit();
		/*List<Tweet> tweetList = getTweets();
		Tweet tweetToDelete = new Tweet();
		for(Tweet t : tweetList)
		{
			if(t.getMessage().equals(message))
			{
				tweetToDelete = t;
			}
		}
		tweetList.remove(tweetToDelete);
		Tweets tweets = new Tweets();
		tweets.setTweets(tweetList);
		
		System.out.println("marshalling tweets...");
		File file = new File("C:\\Users\\FT22\\workspace\\tweets.xml");
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Tweets.class);
			Marshaller marshaller = jaxbContext.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(tweets, file);
			marshaller.marshal(tweets, System.out);
		} catch (JAXBException e)
		{
			System.out.println("marshall failed");
			e.printStackTrace();
			return false;
		}*/
	}

	@Override
	public List<Tweet> getByUser(User user)
	{
		System.out.println("getting tweet for");
		Configuration config = new Configuration();
		config.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		String hql = "FROM Tweet WHERE user_id = :userid";
		Query q = session.createQuery(hql);
		q.setInteger("userid", user.getId());
		List<Tweet> tweets = q.list();
		session.close();
		
		return tweets;
	}

}
