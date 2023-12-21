package com.codegnan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Question;

/**
 * Hello world!
 *
 */
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
        
        session.beginTransaction();
        
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("Lakshmi", "Java is a programming language");
        map1.put("Swathi", "Java is a platform");
        
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Harsh", "Java Database Connectivity");
        map2.put("Gopal", "JDBC is an API");
        map2.put("Radhika", "Underlaying framework for all JPA implementations");
        
        Question question1 = new Question();
        question1.setQname("What is Java");
        question1.setUsername("Kishor");
        question1.setAnswer(map1);
        
        Question question2 = new Question();
        question2.setQname("What is JDBC");
        question2.setUsername("Kumar");
        question2.setAnswer(map2);
        
        session.persist(question1);
        session.persist(question2);
        
        session.getTransaction().commit();
        session.close();
    }
}
