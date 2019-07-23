package com.hibernate.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		/*-session.beginTransaction();
		Instructor instructor = session.get(Instructor.class, 1);
		
		Course course1 = new Course("God Of War");
		Course course2 = new Course("NFS");
		
		instructor.addCourse(course1);
		instructor.addCourse(course2);
		
		session.save(course1);
		session.save(course2);
		
		session.getTransaction().commit();*/

		session.beginTransaction();
		Instructor instructor = session.get(Instructor.class, 1);
		System.out.println(instructor);
		System.out.println("Courses: " + instructor.getCourses());

		session.close();
		factory.close();

	}

}
