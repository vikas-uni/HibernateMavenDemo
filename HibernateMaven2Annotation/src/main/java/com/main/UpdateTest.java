package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.infogain.persistence.HibernateUtil;

public class UpdateTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		//Employee emp=(Employee)s.get(Employee.class, 5);
		System.out.println("Before Update ");
		//System.out.println("Emp Name is "+emp.getName());
		Employee emp=new Employee();
		emp.setEid(3);
		emp.setMobno("99834539");
		emp.setName("CDWas");
		Transaction tx=s.beginTransaction();
		//s.update(emp);
		/*In discussion of save() method, we forgot about case where we had to save persistent entity in another session and that got resulted in duplicate key error. 
		 * That is also a valid scenario.

		To handle such cases, you must use saveOrUpdate() method. Strictly speaking, you should use saveOrUpdate() with even non-persistent entities. */
		s.saveOrUpdate(emp); 
		tx.commit();
		s.close();
		System.out.println("Updated..");

	}

}
