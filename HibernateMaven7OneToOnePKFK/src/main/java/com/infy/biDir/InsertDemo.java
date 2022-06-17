package com.infy.biDir;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InsertDemo {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		
		HeadOfState hos=new HeadOfState();
		hos.setName("Modi");
		hos.setTitle("PM");
		
		Country c=new Country();
		c.setName("India");
		c.setHos(hos);	
		
		HeadOfState hos2=new HeadOfState();
		hos2.setName("D.Trump");
		hos2.setTitle("President");
		
		Country c2=new Country();
		c2.setName("USA");
		c2.setHos(hos2);	
		
		
		//Persisting  country objects
		
		session.save(c);
		session.save(c2);
		
		
		session.getTransaction().commit();
		session.close();
		System.out.println("successfully performed");
	}

}
