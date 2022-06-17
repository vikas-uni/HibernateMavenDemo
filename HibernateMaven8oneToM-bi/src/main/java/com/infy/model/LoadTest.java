package com.infy.model;

import java.util.*;
import org.hibernate.*;

public class   LoadTest  {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
	//	System.out.println("Enter Emp Id:");
		//int id=in.nextInt();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		/*Employee emp=(Employee)session.get(Employee.class,id);
		System.out.println("Emp Details: ");
		System.out.println(emp.getFirstname()+"\t"
		+emp.getJob()+"\t"+emp.getSalary());
		Set<Previledge> set=emp.getPreviledge();
		Iterator<Previledge> itr=set.iterator();
		System.out.println(
				"Previliges availed by the Emp:");
		while(itr.hasNext())
		{
			Previledge p=itr.next();
	System.out.println(p.getPreviledgeId()+"\t"+
			p.getName()+"\t"+p.getCost());
		}*/
	System.out.println("Enter Previlige Id:");
		int pid=in.nextInt();
		Previledge p=(Previledge)
				session.get(Previledge.class,pid);
		System.out.println(
				"Previlige details:");
		System.out.println(p.getPreviledgeId()+"\t"+
				p.getName()+"\t"+p.getCost());
		Set<Employee> eset=p.getEmployees();
		Iterator<Employee> eitr=eset.iterator();
		System.out.println(
				"Following Emp avails this previlige: ");
		while(eitr.hasNext())
		{
			Employee e=eitr.next();
			System.out.println(e.getFirstname()+"\t"
					+e.getJob()+"\t"+e.getSalary());
		}
		in.close();
		session.close();
	}

}
