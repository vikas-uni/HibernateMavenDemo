package com.main;
import com.entity.Employee;
import com.infogain.persistence.HibernateUtil;


import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class SecondaryCacheDemo {
	public static void main(String[] args) {

		// Get session factory using Hibernate Util class
		SessionFactory sf = HibernateUtil.getSessionFactory();

		// Get session from Session factory
		Session session1 = sf.openSession();

		// Load the Employee details whose Id is 101
		Employee employee = (Employee) session1.load(Employee.class, new Integer(1));
		printDetaisl(employee);
session1.clear();
		// Create a new Session
		Session session2 = sf.openSession();
		// Load the same Employee again with new Session
		employee = (Employee) session2.load(Employee.class, new Integer(1));
		printDetaisl(employee);
		
		session1.close();
		session2.close();
		System.out.println(sf.getStatistics());
		sf.close();
	}

	private static void printDetaisl(Employee employee) {
		System.out.println(employee);
				
	}
}
