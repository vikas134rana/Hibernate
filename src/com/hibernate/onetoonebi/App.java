package com.hibernate.onetoonebi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		/*session.beginTransaction();
		InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1);
		
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
		
		session.getTransaction().commit();*/
		
		
		// delete
		/*- session.beginTransaction();
		InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
		
		session.delete(instructorDetail);
		
		session.getTransaction().commit();*/
		

		session.close();
		factory.close();

	}

}
