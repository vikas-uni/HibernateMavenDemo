package com.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.infogain.persistence.HibernateUtil;

public class FirstLevelCacheWithinSameSession {
	public static void main(String[] args) {
		// Get session factory using HibernateUtil class
		SessionFactory sf = HibernateUtil.getSessionFactory();
		// Get session from Session factory
		Session session = sf.openSession();
		
		//Load the Employee details whose Id is 101
		Employee employee = (Employee) session.load(Employee.class, new Integer(1));
		printEmployee(employee);
		
		//Load the same Employee again within the same Session
		employee = (Employee) session.load(Employee.class, new Integer(1));
		printEmployee(employee);
		session.close();
	}

	private static void printEmployee(Employee employee) {
		System.out.println(employee);
				
	}

}
