package App.Hibernate;

import Entities.*;
import Util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class LinkedPurchaseListTableCreatorViaSubscriptions {

    public static void main(String[] args) {

        SessionFactory sessionFactory = SessionFactoryUtil.createSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Subscription> subscriptions = session.createQuery(
                "From " + Subscription.class.getSimpleName(), Subscription.class
        ).getResultList();

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        subscriptions.forEach(subscription -> {
            courses.add(subscription.getComId().getCourse());
            students.add(subscription.getComId().getStudent());
        });


        List<LinkedPurchaseList> linkedPurchaseLists = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            linkedPurchaseLists.add(new LinkedPurchaseList(
                    students.get(i).getId(), courses.get(i).getId(),students.get(i).getName(),courses.get(i).getName(),
                    students.get(i).getRegistrationDate(), courses.get(i).getPrice()
            ));
        }


        linkedPurchaseLists.forEach(session::save);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }
}
