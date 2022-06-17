package com.infy.App;



import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infy.Util.HibernateUtil;
import com.infy.model.Country;
import com.infy.model.HeadOfState;
public class InsertEntity {
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
		
		
		//persisting 2 country objects
		
		session.save(c);
		session.save(c2);
		
	
		session.getTransaction().commit();
		session.close();
		System.out.println("successfully performed");
	}

}
