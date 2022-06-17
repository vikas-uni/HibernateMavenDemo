package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class MainApp {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();

		Employee emp = new Employee();

		emp.setEid(102);
		emp.setName("Ravic");
		emp.setMobno("77890");

		// Transaction tx=s.beginTransaction();
		s.save(emp);
		// tx.commit();
		s.flush(); // autocommitt is true in hibernate cfg, so flush is needed
		s.close();
		System.out.println("Persisted...");

	}

}
