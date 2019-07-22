package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class TestCreate {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		Student student = new Student("Ayush", "karanwal", "ayush@gmail.com");
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
