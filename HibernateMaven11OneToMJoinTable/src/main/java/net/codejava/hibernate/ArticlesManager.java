package net.codejava.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * This program demonstrates how to use JPA annotations to map
 * a one-to-many association on join table in Hibernate.
 * @author www.codejava.net
 *
 */
public class ArticlesManager {
	static SessionFactory sessionFactory;
	static{
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

		// builds a session factory from the service registry
		 sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

	}

	public static void main(String[] args) {
		//add();
		list();
	}
	
	private static void add(){
		// obtains the session
				Session session = sessionFactory.openSession();
				session.beginTransaction();

				Category category = new Category("Spring Framework");

				Article articleOne = new Article("Spring-One Mapping",
						"Spring-One XML Mapping Tutorial", "Hibernate,Spring-One",
						"Content of Spring-One XML Mapping Tutorial");
				Article articleTwo = new Article("Spring-Many Mapping",
						"Spring-Many XML Mapping Tutorial", "Hibernate,Spring-Many",
						"Content of Spring-Many XML Mapping Tutorial");
				Article articleThree = new Article("Many-to-Many Mapping",
						"Many-to-Many XML Mapping Tutorial", "Hibernate,Many-to-Many",
						"Content of Many-to-Many XML Mapping Tutorial");

				Set<Article> articles = new HashSet<Article>();
				articles.add(articleOne);
				articles.add(articleTwo);
				articles.add(articleThree);

				category.setArticles(articles);

				session.save(category);

				session.getTransaction().commit();
				//session.flush();  // not inserting values
				session.close();
	}

	private static void list(){
		
				Session session = sessionFactory.openSession();
				Criteria cr = session.createCriteria(Category.class);
				List<Category> list = cr.list();
				for (Category cat : list) {
					System.out.println(cat.getName());
				}
				//Category cat = (Category)session.get(Category.class, 1L);
				//System.out.println(cat.getName());
				session.close();
	}
}