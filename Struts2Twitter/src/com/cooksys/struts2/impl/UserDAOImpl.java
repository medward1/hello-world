package com.cooksys.struts2.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cooksys.hibernate.models.User;
import com.cooksys.struts2.dao.UserDAO;

public class UserDAOImpl implements UserDAO
{
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	@Override
	public User getById(Integer id)
	{
		Configuration config = new Configuration();
		config.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		String hql = "FROM User WHERE id = :userid";
		Query q = session.createQuery(hql);
		q.setInteger("userid", id);
		User user = (User) q.uniqueResult();
		
		session.close();
		return user;
	}

	@Override
	public User getByUsername(String username)
	{
		System.out.println("getting user by username");
		Configuration config = new Configuration();
		config.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		String hql = "FROM User WHERE username = '" + username + "'";
		Query q = session.createQuery(hql);
		User user = (User) q.uniqueResult();
		System.out.println(user.getUsername() + " " + user.getPassword());
		
		session.close();
		return user;
	}

	@Override
	public void save(User userToSave)
	{
		Configuration config = new Configuration();
		config.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userToSave);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(User userToDelete)
	{
		Configuration config = new Configuration();
		config.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(userToDelete);
		session.getTransaction().commit();
		session.close();
	}
	
}
