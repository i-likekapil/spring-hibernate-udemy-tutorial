package io.kapil.springdemo.hibernate.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.security.spec.ECField;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 30/07/23
 * @Time 10:31 am
 */

public class BiDirectionalDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        InstructorDetails instructorDetails = new InstructorDetails("https://www.linkedin.com/in/i-likekapil", "Sleeping");
        Instructor instructor = new Instructor("Tushar", "Sahni", "tushar.sahni@google.com", instructorDetails);
        try {
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();

        } catch (Exception e) {

        } finally {
            session.close();
            factory.close();
        }
    }
}
