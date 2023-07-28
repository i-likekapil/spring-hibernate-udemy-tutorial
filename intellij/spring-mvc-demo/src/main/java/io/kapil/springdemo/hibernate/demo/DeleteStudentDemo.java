package io.kapil.springdemo.hibernate.demo;

import io.kapil.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 28/07/23
 * @Time 10:57 pm
 */

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {
            session.beginTransaction();
            Student student = session.get(Student.class, 1);
            //delete a student whose id is 1
            session.delete(student);
            session.getTransaction().commit();


            // delete a student where id is 7
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("delete Student where id=7").executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
