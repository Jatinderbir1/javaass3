package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class productDb {
	
	public void add(Object model) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s  = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(model);
		tx.commit();
		s.close();
		factory.close();
		
	}


}
