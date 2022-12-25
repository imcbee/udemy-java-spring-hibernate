package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			
			// start the transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list(); //getResultList(): hibernate 5.2+ update
			
			//display the students
			displayStudents(theStudents);
			
			// query the students with last name "Doe"
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
			
			// display students
			System.out.println("\n\nStudents who have the last name 'Doe': ");
			displayStudents(theStudents);
			
			//  query students with the last name 'Doe' OR  first name 'Daffy'
			theStudents = session.createQuery("from Student s where" + " s.lastName='Doe' OR s.firstName='Daffy'").list();
			
			System.out.println("\n\nStudents who have the last name 'Doe' OR 'Daffy': ");
			displayStudents(theStudents);
			
			// query student where email LIKE 'luv2code.com'
			theStudents = session.createQuery("from Student s where " + " s.email LIKE '%luv2code.com'").list();
			
			System.out.println("\n\nStudents whose email ends with luv2code.com: ");
			displayStudents(theStudents);
			
			// query student where email LIKE 'gmail.com'
			theStudents = session.createQuery("from Student s where " + " s.email LIKE '%gmail.com'").list();
						
			System.out.println("\n\nStudents whose email ends with gmail.com: ");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!!!");
			
		} finally {
			
			factory.close();
			
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student student : theStudents) {
			System.out.println(student);
		}
	}

}
