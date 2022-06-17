package com.infy.biDir;

import java.sql.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoadTest {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Scanner in=new Scanner(System.in);
		
		session = sf.openSession();
		session.beginTransaction();
		
		System.out.println("enter hos id:");
		int hosId=in.nextInt();
		HeadOfState hos2=(HeadOfState) session.get(HeadOfState.class,hosId);
		System.out.println("Head Of state Details:");
		System.out.println("hos name:"+hos2.getName());
		
		Country c2=hos2.getCountry();
		System.out.println("country name:"+c2.getName());
		session.getTransaction().commit();
		session.close();
		
		System.out.println("successfully performed");
	}

}








