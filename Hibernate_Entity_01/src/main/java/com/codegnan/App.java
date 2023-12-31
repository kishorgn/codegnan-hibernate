package com.codegnan;

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
public class App {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
											.configure("hibernate.cfg.xml")
											.build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		Employee employee = new Employee(1, "Kishor", "kishorgn@gmail.com");
		Address address = new Address(1, "G-21, Lohia Nagar", "Gaziabad");
		employee.setAddress(address);
		address.setEmployee(employee);
		
		session.save(employee);
		session.save(address);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
