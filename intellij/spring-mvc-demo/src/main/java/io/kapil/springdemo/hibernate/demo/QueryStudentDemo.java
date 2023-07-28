package io.kapil.springdemo.hibernate.demo;

import io.kapil.springdemo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 28/07/23
 * @Time 10:33 pm
 */

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            // start a transaction
            session.beginTransaction();

            // query student
            final String fromStudent = "from Student";
            List<Student> studentList = session.createQuery(fromStudent).getResultList();

            //display a student
            System.out.println(studentList);

            // query student with last name is Mishra
            studentList = session.createQuery("from Student s where s.lastName='Mishra'").getResultList();
            System.out.println("whose last name is mishra");

            System.out.println(studentList);
// query student with last name is rajput or first name is mohit
            studentList = session.createQuery("from Student s where s.lastName='Mishra' or s.firstName='Mohit'").getResultList();
            System.out.println("whose first name is mohit or last name is mishra");

            System.out.println(studentList);

            // query student where email like '%@google.com'
            studentList = session.createQuery("from Student s where s.email like '%@google.com'").getResultList();
            System.out.println("whose email like '%@google.com'");

            System.out.println(studentList);


            // commit a transaction
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
