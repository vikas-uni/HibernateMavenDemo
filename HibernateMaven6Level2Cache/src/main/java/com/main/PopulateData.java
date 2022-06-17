package com.main;
import com.entity.Employee;
import com.infogain.persistence.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class PopulateData {
public static void main(String[] args) {

	// Get session factory using Hibernate Util class
	SessionFactory sf = HibernateUtil.getSessionFactory();
	// Get session from Sesson factory
	Session session = sf.openSession();

	// Begin transaction
	Transaction t = session.beginTransaction();
	
	//Create Employee  data

}

}
