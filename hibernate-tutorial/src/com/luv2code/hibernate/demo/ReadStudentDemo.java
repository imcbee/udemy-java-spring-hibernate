package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// use session object to save java object
			
			// create a student object
			System.out.println("Creating a new Student Object... ");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
			
			// start the transaction
			session.beginTransaction();
			
			
			// save the student object
			System.out.println("saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			//----------------NEW CODE---------------- (retrieving an object)
			
			// find out the student's id primary key
			System.out.println("Saved student.  Generate ID: " + tempStudent.getId());
			
			// get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student by ID: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		} finally {
			
			factory.close();
			
		}

	}

}
