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

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(InstructorDetails.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //start a transaction
            session.beginTransaction();


            // get an instructor by id
            // return null if not found
            Instructor instructor = session.get(Instructor.class,1);

            if(instructor != null) {
                // delete an instructor
                // Note : this will also delete details obj because cascading
                session.delete(instructor);
            }
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
