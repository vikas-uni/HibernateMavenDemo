package com.infy.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.infy.model.Employee;
import com.infy.model.Person;
import com.infy.model.Student;
import com.infy.util.HibernateUtil;

public class PersistEmployee {
	
	public static void main(String[] args) {
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session sess=factory.openSession();
		Transaction tx=sess.beginTransaction();

		Person p1=new Person("Megha");
		
		Employee e1=new Employee("Gaurav","Trainee",50000L);
		
		Student s1=new Student("Yashika","Java",20000);
		sess.save(p1);
		sess.save(e1);
		sess.save(s1);
		
		tx.commit();
		sess.close();	
		System.out.println("operation successfull");
		HibernateUtil.shutdown();
	}

}






