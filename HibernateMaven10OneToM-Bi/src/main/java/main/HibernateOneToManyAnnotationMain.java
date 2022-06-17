package main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.FetchMode;
import org.hibernate.criterion.Restrictions;

import util.HibernateAnnotationUtil;

import model.Cart1;
import model.Items1;

/*https://www.journaldev.com/2924/hibernate-one-to-many-mapping-annotation
*/
public class HibernateOneToManyAnnotationMain {

	public static void main(String[] args) {
		
		list();
	update(2);
		list();
	}
	
	private static void insert(){
		Cart1 cart = new Cart1();
		cart.setName("MyCart3");
		
		Items1 item1 = new Items1("I12", 12, 1, cart);
		Items1 item2 = new Items1("I22", 22, 2, cart);
		Set<Items1> itemsSet = new HashSet<Items1>();
		itemsSet.add(item1); 
		itemsSet.add(item2);
		
		cart.setItems1(itemsSet);
		cart.setTotal(10*1 + 20*2);
		
		SessionFactory sessionFactory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.openSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(cart);
		//if cascade is enabled in Cart1 then no need to save item manually
		//session.save(item1);
		//session.save(item2);
		//Commit transaction
		tx.commit();
		System.out.println("Cart1 ID="+cart.getId());
		System.out.println("item1 ID="+item1.getId()+", Foreign Key Cart ID="+item1.getCart1().getId());
		System.out.println("item2 ID="+item2.getId()+", Foreign Key Cart ID="+item1.getCart1().getId());
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}
	private static void list(){
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//Criteria cr = session.createCriteria(Cart1.class).add(Restrictions.idEq(new Long(1L)));
		//cr.setFetchMode("items1", org.hibernate.FetchMode.EAGER);  //for n+1 query problem 
		//n+1 solution using HQL
		Query qry = session.createQuery("from Cart1 cart join fetch cart.items1 Items where cart.id=1L");//
		List<Cart1> ls = qry.list();
		//List<Cart1> ls = cr.list();
		for (Cart1 object : ls) {
			System.out.println("Cart: "+object.getName());
			for (Items1 item : object.getItems1()) {
				System.out.println("\t"+"Items: "+item.getItemId());
			}
			System.out.println("*****************");
		}
		session.close();
		//System.out.println(ls);
	}
	
	private static void update(long id){
		SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Cart1 cart = (Cart1)session.load(Cart1.class, id);
		cart.setTotal(500.0);
		Set<Items1> it = cart.getItems1();
		Iterator<Items1> itr = it.iterator();
		while (itr.hasNext()) {
			Items1 type = itr.next();
			type.setItemTotal(830.0);
			
		}
		session.update(cart);
		session.getTransaction().commit();
		session.close();
		
	}

}