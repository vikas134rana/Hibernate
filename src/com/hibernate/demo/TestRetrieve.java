package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class TestRetrieve {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
		Student student = session.get(Student.class, 1);
		session.getTransaction().commit();		
		System.out.println(student);
		
		session.close();
		factory.close();

	}

}
