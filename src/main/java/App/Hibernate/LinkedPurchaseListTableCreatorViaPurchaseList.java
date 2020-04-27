package App.Hibernate;

import Entities.Course;
import Entities.LinkedPurchaseList;
import Entities.PurchaseList;
import Entities.Student;
import Util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LinkedPurchaseListTableCreatorViaPurchaseList {

    public static void main(String[] args) {

        SessionFactory factory = SessionFactoryUtil.createSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<PurchaseList> purchaseLists = session.createQuery(
                    "FROM " + PurchaseList.class.getSimpleName(), PurchaseList.class)
                    .getResultList();

            List<Student> students = session.createQuery(
                    "FROM " + Student.class.getSimpleName(), Student.class)
                    .getResultList();

            List<Course> courses = session.createQuery(
                    "FROM " + Course.class.getSimpleName(), Course.class)
                    .getResultList();

            List<LinkedPurchaseList> linkedPurchaseLists = new ArrayList<>();

            for (PurchaseList purchaseList : purchaseLists) {

                String studentName = purchaseList.getStudentName();
                String courseName = purchaseList.getCourseName();
                int price = purchaseList.getPrice();
                Date subscriptionDate = purchaseList.getSubscriptionDate();
                
                int studentId = 0;
                int courseId = 0;

                for (Student student : students) {
                    if (purchaseList.getStudentName().equalsIgnoreCase(student.getName())) {
                        studentId = student.getId();
                    }
                }

                for (Course course : courses) {
                    if (purchaseList.getCourseName().equalsIgnoreCase(course.getName())) {
                        courseId = course.getId();
                    }
                }

                linkedPurchaseLists.add(new LinkedPurchaseList(
                        studentId, courseId, studentName, courseName, subscriptionDate, price
                ));
            }

            System.out.println(purchaseLists.size());


            linkedPurchaseLists.forEach(System.out::println);

            linkedPurchaseLists.forEach(session::save);

            session.getTransaction().commit();


        } finally {
            factory.close();
            session.close();
        }
    }
}
