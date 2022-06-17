package com.infogain.main;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.infogain.model.Employee;
import com.infogain.util.HibernateUtils;
public class HibernateCriteriaAPIExamples {
     @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Prep work
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
 
        System.err.println("\n\n******** Get All Employees ********");
        Criteria criteria = session.createCriteria(Employee.class);
        List<Employee> empList = criteria.list();
        for(Employee emp : empList){
            System.out.println(emp);
        }
         
        System.out.println("\n\n******** Get with ID, creating new Criteria to remove all the settings ********");
        criteria = session.createCriteria(Employee.class)
                    .add(Restrictions.eq("id", new Long(2)));
        
        Employee emp = (Employee) criteria.uniqueResult();
        
        System.out.println(emp);
 
        System.err.println("\n\n******** Pagination Example ********");
        empList = session.createCriteria(Employee.class)
                    .addOrder(Order.desc("id"))
                    .setFirstResult(0)
                    .setMaxResults(2)
                    .list();
        for(Employee emp4 : empList){
            System.out.println("Paginated Employees::"+emp4);
        }
 
        System.err.println("\n\n******** Like example ********");
        empList = session.createCriteria(Employee.class)
                .add(Restrictions.like("name", "%i%"))
                .list();
        for(Employee emp4 : empList){
            System.out.println("Employees having 'i' in name::"+emp4);
        }
         
        System.err.println("\n\n******** Projections example ********");
        long count = (Long) session.createCriteria(Employee.class)
                .setProjection(Projections.rowCount())
                .add(Restrictions.like("name", "%S%"))
                .uniqueResult();
       
        System.out.println("Number of employees with 's' in name="+count);
 
        System.err.println("\n\n******** Using Projections for sum, min, max aggregation functions ********");
        
        double sumSalary = (Double) session.createCriteria(Employee.class)
            .setProjection(Projections.sum("salary"))
            .uniqueResult();
        System.out.println("Sum of Salaries="+sumSalary);
               
        // Rollback transaction to avoid messing test data
        tx.commit();
        // closing hibernate resources
        sessionFactory.close();
    }
 
}
