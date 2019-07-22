package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class TestQuery {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		List<Student> allData = session.createQuery("from Student").getResultList();
		System.out.println("\nAll DATA ********************* ");
		System.out.println(allData);
		
		List<Student> list1 = session.createQuery("from Student s where s.firstName = 'Vikas'").getResultList();
		System.out.println("\nFirstName=Vikas ********************* ");
		System.out.println(list1);
		
		List<Student> list2 = session.createQuery("from Student s where s.firstName = 'Vikas' OR s.lastName='Karanwal' ").getResultList();
		System.out.println("\nFirstName=Vikas OR LastName=Karanwal ********************* ");
		System.out.println(list2);
		
		List<Student> list3 = session.createQuery("from Student s where s.email LIKE '%@gmail.com' ").getResultList();
		System.out.println("\neamil ends with @gmail.com ********************* ");
		System.out.println(list3);
		
		session.getTransaction().commit();		
		
		
		session.close();
		factory.close();

	}

}
