package io.kapil.springdemo.hibernate.lazyEager;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 31/07/23
 * @Time 02:52 pm
 */

public class CreateCourseDemoOption1 {
    public static void main(String[] args) {

        // option 1
        // call getter method while session is open to use after session close
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
            Instructor instructor = session.get(Instructor.class, 2);
            System.out.println(instructor);
            System.out.println("session is open...");
            System.out.println(instructor.getCourses());

            session.getTransaction().commit();
            session.close();
            /*
            * @OneToMany(fetch = FetchType.EAGER/FetchType.LAZY, mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
            *  private List<Course> courses;
            * */
            System.out.println("session is closed...");
            System.out.println(instructor.getCourses());
            //create some courses
            /*Course course1 = new Course("Javascript");
            Course course2 = new Course("React");
            //add courses to instructor

            instructor.addCourse(course1);
            instructor.addCourse(course2);

            //save the courses
            session.save(course1);
            session.save(course2);*/

            //commit a transaction
            //session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close a session
            //session.close();
            //close a factory
            factory.close();
        }
    }
}
