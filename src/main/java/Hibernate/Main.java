package Hibernate;

import SkillBoxClasses.Course;
import SkillBoxClasses.Student;
import SkillBoxClasses.Subscription;
import SkillBoxClasses.idComposite;
import Util.HibernateUtil;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Id;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

        Session session = sessionFactory.openSession();

        List<Subscription>resultList = session.createQuery("FROM "
                + Subscription.class.getSimpleName()).getResultList();

        resultList.forEach(subscription -> {
            System.out.println(subscription.getComId().getStudent().getName());
            System.out.println(subscription.getComId().getCourse().getName());
            System.out.println(subscription.getSubscriptionDate());
            System.out.println("==========");

        });

//        Subscription subscription = session.get(Subscription.class,);
//        System.out.println(subscription.getComId().getCourse().getName());

//        System.out.println(subscription.getComId().getCourse().getName());


        /*Course course = session.get(Course.class, 1);


        List<Student> studentList = course.getStudents();

        System.out.println("Курс: " + course.getName());
        studentList.forEach(student -> System.out.println(student.getName()));
*/
        sessionFactory.close();

    }


}
