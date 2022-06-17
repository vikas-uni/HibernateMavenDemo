package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.infogain.persistence.HibernateUtil;

public class LoadTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		
		//Employee emp=(Employee)s.get(Employee.class,5);
		Employee emp=(Employee)s.load(Employee.class,5);
		System.out.println(emp);//.getName());
		
		

	}

}
