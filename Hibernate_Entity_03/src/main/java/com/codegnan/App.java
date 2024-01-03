package com.codegnan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
		
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
    }
}
