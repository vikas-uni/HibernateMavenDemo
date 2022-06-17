package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.infogain.persistence.HibernateUtil;

public class FirstLevelCacheWithNewSession {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Get session factory using HibernateUtil class
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		// Get session from Session factory
		Session session1 = sf.openSession();

		// Load the Employee details whose Id is 1
		Employee employee = (Employee) session1.load(Employee.class, new Integer(1));
		printEmployee(employee);

		//Create a new Session
		Session session2 = sf.openSession();
		// Load the same Employee again with new Session
		employee = (Employee) session2.load(Employee.class, new Integer(1));
		printEmployee(employee);
		session1.close();
		session2.close();
	}
	private static void printEmployee(Employee employee) {
		System.out.println(employee);
				
	}

}
