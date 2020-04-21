package Hibernate;

import SkillBoxClasses.Course;
import SkillBoxClasses.LinkedPurchaseList;
import SkillBoxClasses.Student;
import SkillBoxClasses.Subscription;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class LinkedPurchaseListTableCreator {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Subscription> subscriptions = session.createQuery("From " + Subscription.class.getSimpleName()).getResultList();

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        subscriptions.forEach(subscription -> {
            courses.add(subscription.getComId().getCourse());
            students.add(subscription.getComId().getStudent());
        });


        List<LinkedPurchaseList> linkedPurchaseLists = new ArrayList<>();

        for (int i = 0; i < courses.size() ; i++) {
            linkedPurchaseLists.add(new LinkedPurchaseList(courses.get(i).getId(), students.get(i).getId()));
        }

        linkedPurchaseLists.forEach(session::save);


        session.close();
        sessionFactory.close();


    }
}
