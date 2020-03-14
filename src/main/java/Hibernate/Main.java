package Hibernate;

import SkillBoxClasses.Course;
import SkillBoxClasses.Student;
import SkillBoxClasses.Subscription;
import Util.HibernateUtil;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

        Session session = sessionFactory.openSession();
        Subscription subscription = session.get(Subscription.class, 1);

        System.out.println(subscription.getCourse().getName());


        /*Course course = session.get(Course.class, 1);


        List<Student> studentList = course.getStudents();

        System.out.println("Курс: " + course.getName());
        studentList.forEach(student -> System.out.println(student.getName()));
*/
        sessionFactory.close();

    }


}
