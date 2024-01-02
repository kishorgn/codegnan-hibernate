package com.codegnan;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Address;
import com.codegnan.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		Employee employee1 = new Employee("Suhas", "suhas@gmail.com");
		Employee employee2 = new Employee("Payal", "payal@gmail.com");
		
		Address address11 = new Address("Rajagopal Street", "Bengaluru");
		Address address12 = new Address("Church Street", "Bengaluru");
		address11.setEmployee(employee1);
		address12.setEmployee(employee1);
		List<Address> addresses1 = new ArrayList<>();
		addresses1.add(address11);
		addresses1.add(address12);
		employee1.setAddresses(addresses1);
		
		Address address21 = new Address("Ambika Chowk", "Indore");
		Address address22 = new Address("Gowri Nagar", "Indore");
		address21.setEmployee(employee2);
		address22.setEmployee(employee2);
		List<Address> addresses2 = new ArrayList<>();
		addresses2.add(address21);
		addresses2.add(address22);
		employee2.setAddresses(addresses2);
		
		session.save(employee1);
		session.save(employee2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
    }
}
