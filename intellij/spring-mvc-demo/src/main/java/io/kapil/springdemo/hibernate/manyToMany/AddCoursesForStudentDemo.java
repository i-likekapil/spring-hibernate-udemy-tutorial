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

public class AddCoursesForStudentDemo {
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

            //get student from database
            Student student = session.get(Student.class, 1);

            System.out.println(student);
            System.out.println(student.getCourses());

            //create one more course
            Course course = new Course("learn nodejs with easyCases");
            Course course1 = new Course("rubix cube");

            //add student to course
            student.addCourse(course);
            student.addCourse(course1);

            //save the course -)
            session.save(course);
            session.save(course1);

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
