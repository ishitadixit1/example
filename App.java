package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Employee employee = new Employee();
        employee.setEmpName("Vishal Kumar Sahu");
        employee.setEmpEmail("vishal.sahu@accolite.com");

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();

//        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);

        Employee savedEmployee = session.get(Employee.class, 1L);
        System.out.println(savedEmployee);


        session.close();
    }
}
