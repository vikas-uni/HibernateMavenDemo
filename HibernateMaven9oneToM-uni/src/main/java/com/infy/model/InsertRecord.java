package com.infy.model;
 
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 
public class InsertRecord {
 
    public static void main(String[] args) { 
        Trainer t1=new Trainer("Ravic");
		Trainer t2=new Trainer("Amit");
		
		Batch b1=new Batch("9 to 12","w/e");
		Batch b2=new Batch("12 to 3","w/e");
		Batch b3=new Batch("10 to 12","w/d");
	    Batch b4=new Batch("3 to 6","w/e");
		
		
		System.out.println("Persisting 4 Batches..");
		SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session s = sf.openSession();
	    Transaction tx=s.beginTransaction();
	    
	    Set<Batch> batchSet1 = new HashSet<Batch>();
	    batchSet1.add(b1);
	    batchSet1.add(b2);
	    
	    Set<Batch> batchSet2 = new HashSet<Batch>();
	    batchSet2.add(b3);
	    batchSet2.add(b4);
	    
	    
	    t1.setBatches(batchSet1);
	    t2.setBatches(batchSet2);
	    
		s.save(t1);
		s.save(t2);
		
		
		tx.commit();
		s.close();
		System.out.println("Successfully saved.");
    }
}






