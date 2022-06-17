package com.infogain.main;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infogain.model.Employee;
import com.infogain.util.HibernateUtils;
public class HQLExample {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		/*
		 * HQL is to perform both select and non-select operations on the data,  but Criteria is only for selecting the data, we cannot perform non-select operations using criteria
HQL is suitable for executing Static Queries, where as Criteria is suitable for executing Dynamic Queries
HQL doesn’t support pagination concept, but we can achieve pagination with Criteria
Criteria used to take more time to execute then HQL
With Criteria we are safe with SQL Injection because of its dynamic query generation but in HQL as your queries are either fixed or parametrized, there is no safe from SQL Injection.
		 */
		
		//Prep work
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		System.out.println("\n\n ********* Get All Employees examples  *********");
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("from Employee");
		List<Employee> empList = query.list();
		for(Employee emp : empList){
			System.out.println("List of Employees::"+emp.getId()+","+emp.getName());
		}
		
		System.err.println("\n\n ********* Get Employee with id examples  *********");
		query = session.createQuery("from Employee where id= :id");
		query.setLong("id", 44);
		
		Employee emp = (Employee) query.uniqueResult();
		System.out.println("Employee Id"+emp.getId()+"Employee Name="+emp.getName());
		
		System.err.println("\n\n ********* Update Employee examples  *********");
		query = session.createQuery("update Employee set name= :name where id= :id");
		query.setParameter("name", "Amit");
		query.setLong("id", 44);
		int result = query.executeUpdate();
		System.out.println("Employee Update Status="+result);
		
		System.err.println("\n\n ********* Delete Employee examples  *********");

		query = session.createQuery("delete from Employee where id= :id");
		query.setLong("id", 45);
		result = query.executeUpdate();
		System.out.println("Employee Delete Status="+result);
				
		System.err.println("\n\n ********* Aggregate function examples  *********");
		query = session.createQuery("select sum(salary) from Employee");
		double sumSalary = (Double) query.uniqueResult();
		System.out.println("Sum of all Salaries= "+sumSalary);
		
				//rolling back to save the test data
		tx.commit();//rollback();
		
		//closing hibernate resources
		sessionFactory.close();
	}

}
