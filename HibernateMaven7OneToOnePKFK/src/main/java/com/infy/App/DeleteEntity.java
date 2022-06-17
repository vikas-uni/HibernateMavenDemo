package com.infy.App;



import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infy.Util.HibernateUtil;
import com.infy.model.Country;

public class DeleteEntity {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Country country= (Country) session.get(Country.class,1);
		session.delete(country);		
		session.getTransaction().commit();
		session.close();
		System.out.println("successfully performed");
	}

}
