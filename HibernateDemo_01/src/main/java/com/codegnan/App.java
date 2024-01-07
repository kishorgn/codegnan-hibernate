package com.codegnan;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Employee;

public class App {
	public static void main(String[] args) {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.configure("hibernate.cfg.xml")
				.build();
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		Metadata meta = metadataSources.getMetadataBuilder().build();
		SessionFactoryBuilder sessionFactoryBuilder = meta.getSessionFactoryBuilder();
		SessionFactory sessionFactory = sessionFactoryBuilder.build();

		Session session = sessionFactory.openSession();
		
		session.getTransaction().begin();

		Query query = session.createQuery("update Employee set firstName=:n where id=:id");
		query.setParameter("n", "James");
		query.setParameter("id", 103);
		int noRec = query.executeUpdate();
		System.out.println("No. records updated : "+noRec);
		
		session.getTransaction().commit();

		session.close();
		sessionFactory.close();
		System.out.println("End of the program.");

	}
}
