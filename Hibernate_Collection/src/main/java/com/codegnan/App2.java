package com.codegnan;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
        	System.out.println("Asked by: "+question.getUsername());
        	Map<String, String> map = question.getAnswer();
        	Set<Map.Entry<String, String>> answers = map.entrySet();
        	Iterator<Map.Entry<String, String>> it = answers.iterator();
        	while(it.hasNext()) {
        		Map.Entry<String, String> answer = it.next();
        		System.out.print("Answer by - "+ answer.getKey() );
        		System.out.println(", Answer : " + answer.getValue() );
        	}
        }
        
        session.close();
    }
}
