package com.codegnan.dao;

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
import com.codegnan.exception.InvalidEmployeeIdException;

public class EmployeeDao {
	public Employee findById(int id) throws InvalidEmployeeIdException {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
    	StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.configure("hibernate.cfg.xml").build();
    	MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
        Metadata meta = metadataSources.getMetadataBuilder().build();
        SessionFactoryBuilder sessionFactoryBuilder = meta.getSessionFactoryBuilder() ;
        SessionFactory sessionFactory = sessionFactoryBuilder.build();
        
        Session session =  sessionFactory.openSession();
		Employee employee = session.get(Employee.class, id) ;
		try {
			if(employee == null) {
				throw new InvalidEmployeeIdException("Employee ID is not valid : "+id);
			}
		}
		finally {
			session.close();
			sessionFactory.close();
		}
		return employee;
		
	}
	public List<Employee> findAll(){
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
    	StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.configure("hibernate.cfg.xml").build();
    	MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
        Metadata meta = metadataSources.getMetadataBuilder().build();
        SessionFactoryBuilder sessionFactoryBuilder = meta.getSessionFactoryBuilder() ;
        SessionFactory sessionFactory = sessionFactoryBuilder.build();
        
        Session session =  sessionFactory.openSession();
        Query query = session.createQuery("from Employee");
        List<Employee> employees = (List<Employee>) query.getResultList();
        session.close();
        sessionFactory.close();
        return employees;
	}
	//save
	//edit
	//delete
}
