package io.kapil.springdemo.hibernate.manyToMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 31/07/23
 * @Time 06:54 pm
 */

public class CreateCourseAndStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();


            //create a course
            Course course = new Course("Java Spring boot with Hibernate");

            //add some review
            Review review1 = new Review("awesome course");
            Review review2 = new Review("mst h course");
            Review review3 = new Review("love this");

            course.addReview(review1);
            course.addReview(review2);
            course.addReview(review3);

            //add some students
            Student student1 = new Student("Kapil", "kaushik", "kapil@kaushik.com");
            Student student2 = new Student("Vishal", "sharma", "vishal@sharma.com");
            Student student3 = new Student("Navin", "kumar", "navin@kumar.com");

            course.addStudent(student1);
            course.addStudent(student2);
            course.addStudent(student3);

            //save the course ... and leverage the cascade all -)
            session.save(student1);
            session.save(student2);
            session.save(student3);
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
