package io.kapil.springdemo.hibernate.oneToManyUniDirectional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 30/07/23
 * @Time 11:54 am
 */

public class GetCourseAndReviewDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //get a course whose id is 10
            Course course = session.get(Course.class, 10);

            System.out.println("course : " + course);
            System.out.println("reviews : " + course.getReviews());

            //commit the transaction
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
