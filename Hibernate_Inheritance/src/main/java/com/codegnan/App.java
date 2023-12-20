package com.codegnan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.ContractEmployee;
import com.codegnan.entity.Employee;
import com.codegnan.entity.RegularEmployee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
        											.configure("hibernate.cfg.xml")
        											.build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
    	
//    	Configuration configuration = new Configuration().configure();
//    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
//    												.applySettings(configuration.getProperties())
//    												.buildServiceRegistry();
//    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        Employee employee = new Employee();
        employee.setName("Kishor Kumar");
        
        RegularEmployee regularEmployee = new RegularEmployee();
        regularEmployee.setName("Rajesh Verma");
        regularEmployee.setSalary(5500);
        regularEmployee.setBonus(15);
        
        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setName("Harsh");
        contractEmployee.setPayPerHr(1000);
        contractEmployee.setContractPeriod("250 hrs");
        
        session.save(employee);
        session.save(regularEmployee);
        session.save(contractEmployee);
        
        session.getTransaction().commit();
        session.close();
    }
}
