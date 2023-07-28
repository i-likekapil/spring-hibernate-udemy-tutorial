package io.kapil.springdemo.hibernate.demo;

import io.kapil.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 28/07/23
 * @Time 9:20 pm
 */

public class StudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {


            // creating a student object
            Student student = new Student("Mohit", "Rajput", "mohit.rajput@google.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            session.save(student);

            // commit the current transaction
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
