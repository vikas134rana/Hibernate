package com.hibernate.maytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		/*- Student student1 = new Student("Tom", "Cruise", "tom@topgun.com");
		session.save(student1);
		Course course1 = new Course("Mission Impossible");
		Course course2 = new Course("Top Gun");
		student1.addCourses(course1);
		student1.addCourses(course2);
		session.save(course1);
		session.save(course2);*/

		Student student = session.get(Student.class, 10);
		System.out.println(student);
		System.out.println(student.getCourses());

		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
