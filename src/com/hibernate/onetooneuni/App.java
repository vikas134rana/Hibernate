package com.hibernate.onetooneuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		Instructor instructor = new Instructor("Vikas", "Rana", "vikas@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("GamingLegends.com", "Gaming");
		instructor.setInstructorDetail(instructorDetail);
		
		session.beginTransaction();
		session.save(instructor);
		session.getTransaction().commit();

		session.close();
		factory.close();
		
	}

}
