package com.codegnan;

import java.util.ArrayList;
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
        
        TreeSet<String> list1 = new TreeSet<>();
        list1.add("Java is a Platform");
        list1.add("Java is a programming language");
        
        TreeSet<String> list2 = new TreeSet<>();
        list2.add("Group of elements");
        list2.add("One of the Java APIs");
        
        Question question1 = new Question();
        question1.setQname("What is Java?");
        question1.setAnswer(list1);
        
        Question question2 = new Question();
        question2.setQname("What is Collection");
        question2.setAnswer(list2);
        
        list1.add("Highly secured language");
        list1.add("Java is a programming language");
        
        session.persist(question1);
        session.persist(question2);
        
        session.getTransaction().commit();
        session.close();
    }
}
