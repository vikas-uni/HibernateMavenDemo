package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.entity.Employee;
import com.infogain.persistence.HibernateUtil;

public class MainApp {
	public static void main(String[] args) {
		
		/*AnnotationConfiguration cfg=new AnnotationConfiguration();
		SessionFactory sf=cfg.configure().buildSessionFactory();*/
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		Employee emp=new Employee();
		
		emp.setName("Rajiv-k");
		emp.setMobno("5897783Sd");
		
		Transaction tx=s.beginTransaction();
		s.persist(emp);
		tx.commit();
		s.close();
		System.out.println("Object Persisted..");
		
		HibernateUtil.shutdown();

	}

}
