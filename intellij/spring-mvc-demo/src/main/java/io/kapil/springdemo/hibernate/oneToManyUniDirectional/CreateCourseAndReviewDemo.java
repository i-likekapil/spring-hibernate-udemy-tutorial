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

public class CreateCourseAndReviewDemo {
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

            //create a course
            Course course = new Course("Pacman How to play pacman game");

            //add some review
            Review review1 = new Review("awesome course");
            Review review2 = new Review("mst h course");
            Review review3 = new Review("love this");

            course.addReview(review1);
            course.addReview(review2);
            course.addReview(review3);

            //save the course ... and leverage the cascade all -)
            session.save(course);

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
