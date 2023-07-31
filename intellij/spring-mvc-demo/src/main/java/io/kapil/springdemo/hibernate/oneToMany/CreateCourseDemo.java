package io.kapil.springdemo.hibernate.oneToMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 30/07/23
 * @Time 11:54 am
 */

public class CreateCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            //get instructor from db
            Instructor instructor = session.get(Instructor.class, 1);

            //create some courses
            Course course1 = new Course("Java");
            Course course2 = new Course("Spring");
            //add courses to instructor

            instructor.addCourse(course1);
            instructor.addCourse(course2);

            //save the courses
            session.save(course1);
            session.save(course2);

            //commit a transaction
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
