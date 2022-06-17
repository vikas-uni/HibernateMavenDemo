package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.infogain.persistence.HibernateUtil;


public class FirstLevelCacheEvict {
	public static void main(String[] args) {
		// Get session factory using HibernateUtil class
		SessionFactory sf = HibernateUtil.getSessionFactory();
		// Get session from Session factory
		Session session = sf.openSession();

		// Load the Employee details whose Id is 101
		Employee employee = (Employee) session.load(Employee.class, new Integer(1));
		printEmployee(employee);


/*evict() evicts a single object from the session. clear() evicts all the objects in the session. Calling clear() is like calling evict() on every object associated with the session.*/
		session.evict(employee);
		
		// Load the same Employee again within the same Session but after evict
		employee = (Employee) session.load(Employee.class, new Integer(1));
		printEmployee(employee);

		

		// Load the Employee details whose Id is 41
		Employee employee1 = (Employee) session.load(Employee.class, new Integer(2));
		printEmployee(employee1);

		// Load the Employee details whose Id is 49
		Employee employee2 = (Employee) session.load(Employee.class, new Integer(3));
		printEmployee(employee2);

		session.clear();

		//Load the employees after clearing the primary cache
		
		// Load the Employee details whose Id is 41
		employee1 = (Employee) session.load(Employee.class, new Integer(2));
		printEmployee(employee1);

		session.close();
		HibernateUtil.shutdown();
	}

	private static void printEmployee(Employee employee) {
		System.out.println(employee);
				
	}

}
