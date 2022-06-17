package com.infy.App;


import java.util.*;
import org.hibernate.*;

import com.infy.Util.HibernateUtil;
import com.infy.model.Country;
import com.infy.model.HeadOfState;
public class LoadTest {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Country Id:");
		int id=in.nextInt();
		SessionFactory sf = HibernateUtil.getSessionFactory();
	    Session session = sf.openSession();
	    Country cry=(Country)session.load(Country.class,id);	
	    System.out.println("country is fetched");
		System.out.println("Country Name: "+cry.getName());
		
		HeadOfState hos=cry.getHos();
		System.out.println(hos.getName());		
		in.close();
		session.close();
	}

}
