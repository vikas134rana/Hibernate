package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class TestUpdate {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Student student = session.get(Student.class, 2);
		student.setLastName("karma");
		session.update(student);
		
//		session.createQuery("Update Student s set email='gmail' where s.id=2").executeUpdate();
		
		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
