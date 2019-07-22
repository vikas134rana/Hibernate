package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class TestDelete {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Student student = session.get(Student.class, 3);
		session.delete(student);
		
//		session.createQuery("Delete from Student s where s.id=2").executeUpdate();
		
		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
