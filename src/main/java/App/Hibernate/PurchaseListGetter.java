package App.Hibernate;

import Entities.PurchaseList;
import Util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PurchaseListGetter {

    public static void main(String[] args) {

        SessionFactory factory = SessionFactoryUtil.createSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<PurchaseList> purchaseLists = session.createQuery("from PurchaseList").getResultList();

            purchaseLists.forEach(purchaseList -> {

                System.out.println("======");
                System.out.println(purchaseList.getStudentName());
                System.out.println(purchaseList.getCourseName());
                System.out.println(purchaseList.getPrice());
                System.out.println(purchaseList.getSubscriptionDate());
            });

        } finally {
            factory.close();
            session.close();
        }
    }
}
