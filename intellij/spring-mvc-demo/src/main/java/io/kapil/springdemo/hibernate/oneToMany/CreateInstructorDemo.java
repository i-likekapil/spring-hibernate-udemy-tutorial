package io.kapil.springdemo.hibernate.oneToMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 30/07/23
 * @Time 11:45 am
 */

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // create the objects
            Instructor instructor = new Instructor("Kapil", "Kaushik", "Kapil.kaushik@cavisson.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://youtube.com", "Coding");

            // associate one object to another object
            instructor.setInstructorDetail(instructorDetail);

            //start a transaction
            session.beginTransaction();

            //save an objects
            //this will automatically save details obj
            //because of CascadeType.ALL property
            session.save(instructor);
            // no need to save dependent object i.e instructorDetails

            // commit a transaction
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close a session
            session.close();
            //close a factory
            factory.close();
        }
    }
}
