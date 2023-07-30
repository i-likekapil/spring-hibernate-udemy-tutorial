package io.kapil.springdemo.hibernate.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 28/07/23
 * @Time 11:47 pm
 */

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create two objects
            Instructor instructor = new Instructor("Kapil", "Kaushik", "kapil.kaushik@google.com");
            InstructorDetails instructorDetails = new InstructorDetails("https://www.ikapil.me", "coding");

            // associate one object to another object
            instructor.setInstructorDetails(instructorDetails);

            //start a transaction
            session.beginTransaction();

            //save an objects
            //this will automatically save details obj
            //because of CascadeType.ALL property
            session.save(instructor);
            // no need to save dependent object i.e instructorDetails

            // commit a transaction
            session.getTransaction().commit();


            //close a session
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close a factory
            factory.close();
        }
    }
}
