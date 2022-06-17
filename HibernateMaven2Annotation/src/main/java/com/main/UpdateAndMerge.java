package com.main;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.infogain.persistence.HibernateUtil;
/*
 * Merge and update:Both of them are used to convert the object which is in detached state into
 *  persistence state, but the major difference between update and merge 
 * is that update method cannot be used when the same object exists in the seesion.
 After merge we will get the latest changed value, 
 since when the merge occurs the value loaded in session gets changed
*/

public class UpdateAndMerge {
	public static void main(String[] args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		Employee current =(Employee) session.get(Employee.class,1);
		System.out.println("Before update/merge: " +current.getName());
		//current.setName("Ravic");
   try{
	Employee changed = new Employee();
     changed.setEid(1);
      changed.setName("Amit2");
      changed.setMobno("343637");
      
	//session.update(current);
      //session.update(changed); // Throws NonUniqueObjectException
       session.merge(changed); // 
       System.out.println("After merge: " + current.getName());
      tx.commit();
      //session.close();
   }catch(Exception e){
	   e.printStackTrace();
   }
finally{
	
	session.close();
}
	}

}
