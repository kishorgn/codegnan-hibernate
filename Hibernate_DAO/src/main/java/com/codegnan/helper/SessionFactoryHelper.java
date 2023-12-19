package com.codegnan.helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryHelper {

	private SessionFactoryHelper() {	}
	static SessionFactory sessionFactory = null;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
	    	StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.configure("hibernate.cfg.xml").build();
	    	MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
	        Metadata meta = metadataSources.getMetadataBuilder().build();
	        SessionFactoryBuilder sessionFactoryBuilder = meta.getSessionFactoryBuilder() ;
	        sessionFactory = sessionFactoryBuilder.build();
		}
		return sessionFactory;
	}

}
