package com.codegnan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Group;
import com.codegnan.entity.User;

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
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		
		Group groupAdmin = new Group("Administrators Group");
		Group groupGuest = new Group("Guests Group");
		
		User user1 = new User("Ramesh", "ramesh@gmail.com");
		User user2 = new User("Suresh", "suresh@gmail.com");
		
		groupAdmin.getUsers().add(user1);
		groupAdmin.getUsers().add(user2);
		groupGuest.getUsers().add(user2);
		
		user1.getGroups().add(groupAdmin);
		user2.getGroups().add(groupAdmin);
		user2.getGroups().add(groupGuest);
		
		session.save(groupAdmin);
		session.save(groupGuest);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
    }
}
