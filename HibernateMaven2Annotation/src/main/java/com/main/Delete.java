package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.infogain.persistence.HibernateUtil;

public class Delete {

	public static void main(String[] args) {
	SessionFactory sf=HibernateUtil.getSessionFactory();
	Session s=sf.openSession();
	Transaction tx=s.beginTransaction();
	Employee emp=(Employee)s.get(Employee.class, 5);
	s.delete(emp);
	tx.commit();
	s.close();
	System.out.println("Removed");
	

	}

}
