package Hibernate;

import Entities.*;
import Util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = SessionFactoryUtil.createSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Subscription>resultList = session.createQuery("FROM "
                + Subscription.class.getSimpleName()).getResultList();

        resultList.forEach(subscription -> {
            System.out.println(subscription.getComId().getStudent().getName());
            System.out.println(subscription.getComId().getCourse().getName());
            System.out.println(subscription.getSubscriptionDate());
            System.out.println("==========");

        });

//
//        session.save();
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }


}
