package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start the transaction
			session.beginTransaction(); //this will save the details object because cascade all
			
			// get the instructor detail object
			int getId = 3;
				//having a bad number will give a null
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, getId);
			
			// print the instructor detail object
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			// print the associated instructor
			System.out.println("the associated Instructor" + tempInstructorDetail.getInstructor());
			
			// delete instructor detail
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
			
			// remove the associated object reference
			// break bi-directional reference
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		} catch(Exception exc) {
			
			exc.printStackTrace();
			
		} finally {
			
			// handle connection leak issue
			session.close();
			
			factory.close();
			
		}

	}

}
