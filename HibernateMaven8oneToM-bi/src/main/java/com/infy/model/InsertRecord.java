package com.infy.model;
 import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
 public class InsertRecord {
 
    public static void main(String[] args) {
 
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
   
        
         Transaction tx=session.beginTransaction();
         
     
        Previledge p1 = new Previledge();
          p1.setName("car");
        p1.setCost(200000);
       
        
        Previledge p2 = new Previledge();
        p2.setName("trip");
        p2.setCost(300000);
        
        Previledge p3 = new Previledge();
        p3.setName("flat");
        p3.setCost(800000);
        
        Employee employee1 = new Employee("jack", "ceo",95000);
        Employee employee2 = new Employee("dazy", "director",90000);
        Employee employee3 = new Employee("ryan", "manager",80000);
        Employee employee4 = new Employee("fizz", "architect",850000);
        Employee employee5 = new Employee("samar", "tester",75000);
        Employee employee6 = new Employee("sam", "deployer",70000);
        Employee employee7 = new Employee("tom", "developer",60000);
        
        
        
   
        
        
        //  *****use first approach*****
        Set<Previledge> s1=new HashSet<Previledge>();
        s1.add(p1);
        s1.add(p2);
        s1.add(p3);
        
        Set<Previledge> s2=new HashSet<Previledge>();
        s2.add(p1);
        s2.add(p2);
        
        Set<Previledge> s3=new HashSet<Previledge>();
        s3.add(p1);
        
        
        employee1.setPreviledge(s1);
        employee2.setPreviledge(s2);
        employee3.setPreviledge(s3);
        employee4.setPreviledge(s1);
        employee5.setPreviledge(s2);
        employee6.setPreviledge(s3);
        employee7.setPreviledge(s3);
         
        session.save(employee1);
        session.save(employee2);        //session.save(employee3);
        session.save(employee4);
        session.save(employee5);
        session.save(employee6);
        session.save(employee7);
        
                
        
        System.out.println("done");

        
     
         tx.commit();
         session.close();
         }
}