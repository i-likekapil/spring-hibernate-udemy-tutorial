package io.kapil.springdemo.hibernate.lazyEager;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 31/07/23
 * @Time 02:52 pm
 */

public class CreateCourseDemoOption2 {
    public static void main(String[] args) {

        // option 2
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
            int id = 2;
            Query<Instructor> query = session.createQuery("select i from Instructor i join fetch i.courses where i.id=:theInstructorId",
                    Instructor.class);
            query.setParameter("theInstructorId", id);

            //execute query and save instructor

            Instructor instructor = query.getSingleResult();

            System.out.println(instructor);
            System.out.println("session is open...");
            //System.out.println(instructor.getCourses());

            session.getTransaction().commit();
            session.close();
            /*
             * @OneToMany(fetch = FetchType.EAGER/FetchType.LAZY, mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
             *  private List<Course> courses;
             * */
            System.out.println("session is closed...");
            //System.out.println(instructor.getCourses());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close a factory
            factory.close();
        }
    }
}
