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
import com.codegnan.helper.SessionFactoryHelper;

public class EmployeeDao {
	public Employee findById(int id) throws InvalidEmployeeIdException {
		
        SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory() ;
        Session session =  sessionFactory.openSession();
		Employee employee = session.get(Employee.class, id) ;
		try {
			if(employee == null) {
				throw new InvalidEmployeeIdException("Employee ID is not valid : "+id);
			}
		}
		finally {
			session.close();
		}
		return employee;
		
	}
	public List<Employee> findAll(){
		SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory() ;
        
        Session session =  sessionFactory.openSession();
        Query query = session.createQuery("from Employee");
        List<Employee> employees = (List<Employee>) query.getResultList();
        session.close();
        return employees;
	}
	public int save(Employee employee) {
		SessionFactory sessionFactory = SessionFactoryHelper.getSessionFactory() ;
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int id = (int)session.save(employee);
		session.getTransaction().commit();
		session.close();
		return id;
	}
	//edit
	//delete
}
