package com.infogain.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.infogain.model.Employee;

public class InsertTest {

	
	public static void main(String[] args) {
		SessionFactory sf=new AnnotationConfiguration()
		.configure().buildSessionFactory();
		Session s=sf.openSession();
		Employee e1=new Employee();
		e1.setName("Rohit");
		e1.setSalary(70000);
		
		Employee e2=new Employee();
		e2.setName("Sachain");
		e2.setSalary(30000);
		
		
		Employee e3=new Employee();
		e3.setName("Saurabh");
		e3.setSalary(90000);
		
		
		Transaction tx=s.beginTransaction();
		s.save(e1);
		s.save(e2);
		s.save(e3);
		tx.commit();
		
		s.close();
		System.out.println("Persisted...");
			}

}
