package com.codegnan;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Employee;


public class App 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
    	StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.configure("hibernate.cfg.xml").build();
    	MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
        Metadata meta = metadataSources.getMetadataBuilder().build();
        SessionFactoryBuilder sessionFactoryBuilder = meta.getSessionFactoryBuilder() ;
        SessionFactory sessionFactory = sessionFactoryBuilder.build();
        
        Session session =  sessionFactory.openSession();
        
//        session.beginTransaction();
        try {
//        	Employee employee = new Employee("Sam", "Peter");
//            session.save(employee);
            
//            session.getTransaction().commit();
//            System.out.println("Saved successfully");
//        	Employee employee = session.get(com.codegnan.entity.Employee.class, 101);
//        	System.out.println(employee);
        	
        	Query query = session.createQuery("from Employee");
        	List<Employee> list = (List<Employee>) query.getResultList();
        	for(Employee emp : list) {
        		System.out.println(emp);
        	}
        	
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
        	session.close();
            sessionFactory.close();
            System.out.println("End of the program.");
        }
           
    }
}
