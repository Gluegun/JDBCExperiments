package Hibernate;

import SkillBoxClasses.*;
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

//
        session.beginTransaction();
//        session.save();
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }


}
