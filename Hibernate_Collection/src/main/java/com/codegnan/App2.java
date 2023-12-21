package com.codegnan;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
public class App2
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
        
        TypedQuery<Question> query = session.createQuery("from Question");
        List<Question> questions = query.getResultList();
        for(Question question : questions) {
        	System.out.println("Question : "+question.getQname());
        	List<String> answers = question.getAnswer();
        	for(String answer : answers) {
        		System.out.println(answer);
        	}
        }
        
        session.close();
    }
}
