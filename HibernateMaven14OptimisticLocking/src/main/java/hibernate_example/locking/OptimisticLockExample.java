package hibernate_example.locking;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

/*
 * Locking database tables/rows is a mechanism to avoid simultaneous updates which may result in unexpected results.
 Optimistic Locking is a check which ensures that from the beginning of a transaction to the commit, the target data is
 not modified by other user. If it does then the current update are discarded, the transaction is rolled back and the current user is informed about that.
 In JPA, an entity field or property annotated with @Version is used to perform optimistic locking. The entity is automatically enabled for optimistic locking if it has such field.
 */

public class OptimisticLockExample {
	/*
	 * private static EntityManagerFactory entityManagerFactory =
	 * Persistence.createEntityManagerFactory("example-unit");
	 */
	private static SessionFactory sf;

	public static void main(String[] args) throws InterruptedException {
		try {
			sf = HibernateUtil.getSessionFactory();
			 //persistEmployee();
			
			Thread th1 = new Thread(new Runnable() {

				public void run() {
					updateEmployeeNewThread("HR", 1);
				}
			});
			th1.start();
			
			Thread th2 = new Thread(new Runnable() {

				public void run() {
					updateEmployeeNewThread("ED", 1);
				}
			});
			th2.start();
			
			updateEmployeeDepartment("Sales", 1);
			
			th1.join();
			th2.join();
			
		} finally {
			 sf.close();
			 System.out.println("Finished----");
		}
	}
	
	private static void updateEmployeeNewThread(String department,
			Object primaryKey) {
		System.out.println("Run by: "+Thread.currentThread().getName());
		Session em = sf.openSession();
		EmployeeLocking employee = (EmployeeLocking) em.load(EmployeeLocking.class, (Integer) primaryKey);
		em.getTransaction().begin();
		employee.setDepartment(department);
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		em.getTransaction().commit();
		em.close();
		System.out.println("Employee updated: " + employee);
	}

	private static void updateEmployeeDepartment(String department,
			Object primaryKey) {
		System.out.println("Run by: "+Thread.currentThread().getName());

		Session em = sf.openSession();
		EmployeeLocking employee = (EmployeeLocking) em.load(EmployeeLocking.class, (Integer) primaryKey);
		em.getTransaction().begin();
		
		employee.setDepartment(department);
		em.getTransaction().commit();
		em.close();
		System.out.println("Employee updated: " + employee);
	}

	public static void persistEmployee() {
		EmployeeLocking employee = new EmployeeLocking("Joe", "IT");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session em = sf.openSession();

		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		em.close();
		System.out.println("Employee persisted: " + employee);
	}
}