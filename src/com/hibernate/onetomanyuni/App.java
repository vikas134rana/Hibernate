package com.hibernate.onetomanyuni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		
		// Save Course and Reviews
		/*- Course course = new Course("Spring Tuts");
		Review review1 = new Review("Awesome Spring tuts");
		Review review2 = new Review("Not good Spring tuts");

		course.addReview(review1);
		course.addReview(review2);
		System.out.println(course.getReviews());
		session.save(course);*/
		
		// get Course and Reviews
		/*- Course course = session.get(Course.class, 18);
		System.out.println(course);
		System.out.println("Reviews: "+course.getReviews());*/
		
		
		// Delete Course (Check Reviews are also cascade deleted)
		Course course = session.get(Course.class, 18);
		session.delete(course);
		
		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
