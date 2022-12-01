package com.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;


public class getProduct {
	
	public static ArrayList<Product> get(String username){
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session s  = factory.openSession();
		Transaction tx = s.beginTransaction();
		String hql = "Select t FROM Product t WHERE t.user = :username";
		Query query = s.createQuery(hql);
		query.setParameter("username",username);
		List<Product> results = query.list();
		tx.commit();
		s.close();
		return (ArrayList<Product>)results;
	}
	
	public static int delete(String id1) {
		int id = Integer.parseInt(id1);
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session s  = factory.openSession();
		Transaction tx = s.beginTransaction();
		String hql = "delete from Product t WHERE t.pid = :id";
		Query query = s.createQuery(hql);
		query.setParameter("id",id);
		int result = query.executeUpdate();
		tx.commit();
		s.close();
		return result;
	}
}
