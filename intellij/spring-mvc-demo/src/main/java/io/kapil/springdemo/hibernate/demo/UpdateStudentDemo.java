package io.kapil.springdemo.hibernate.demo;

import io.kapil.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 28/07/23
 * @Time 10:51 pm
 */

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {
            session.beginTransaction();
            Student student = session.get(Student.class, 7);
            //update name of a student whose id is 7
            student.setFirstName("Chammiya");
            session.getTransaction().commit();


            // update email for all students
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
