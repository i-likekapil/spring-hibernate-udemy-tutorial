package io.kapil.springdemo.hibernate.demo;

import io.kapil.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 28/07/23
 * @Time 10:19 pm
 */

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            Student student = new Student("Mohit","Rajput","mohit.rajput@google.com");

            session.save(student);

            student = new Student("Tushar","Sahni","tushar.sahni@google.com");

            session.save(student);

            student = new Student("Vivek","Mishra","vivek.mishra@google.com");

            session.save(student);

            session.getTransaction().commit();

            // new code for read data from db to java code
            session = factory.getCurrentSession();
            session.beginTransaction();
            // now retrieve student from mysql using hibernate
            final Student student1 = session.get(Student.class, student.getId());
            System.out.println(student1);

            session.getTransaction().commit();




        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
