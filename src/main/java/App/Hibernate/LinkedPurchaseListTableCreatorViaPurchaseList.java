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

            List<PurchaseList> purchaseLists = session.createQuery("FROM " + PurchaseList.class.getSimpleName()).getResultList();

            List<Student> students = session.createQuery("FROM " + Student.class.getSimpleName()).getResultList();

            List<Course> courses = session.createQuery("FROM " + Course.class.getSimpleName()).getResultList();

            List<Integer> studentsId = new ArrayList<>();
            List<Integer> coursesId = new ArrayList<>();
            List<String> studentNames = new ArrayList<>();
            List<String> courseNames = new ArrayList<>();
            List<Integer> coursePrices = new ArrayList<>();
            List<Date> subscriptionDates = new ArrayList<>();


            purchaseLists.forEach(purchaseList -> {
                String studentName = purchaseList.getStudentName();
                students.forEach(student -> {
                    if (student.getName().equalsIgnoreCase(studentName)) {
                        studentsId.add(student.getId());
                        studentNames.add(student.getName());
                        subscriptionDates.add(student.getRegistrationDate());
                    }
                });
                String courseName = purchaseList.getCourseName();
                courses.forEach(course -> {
                    if (course.getName().equalsIgnoreCase(courseName)) {
                        coursesId.add(course.getId());
                        courseNames.add(course.getName());
                        coursePrices.add(course.getPrice());
                    }
                });
            });

            List<LinkedPurchaseList> linkedPurchaseLists = new ArrayList<>();

            for (int i = 0; i < purchaseLists.size(); i++) {
                linkedPurchaseLists.add(new LinkedPurchaseList(
                        studentsId.get(i), coursesId.get(i), studentNames.get(i), courseNames.get(i),
                        subscriptionDates.get(i), coursePrices.get(i)));
            }

//            linkedPurchaseLists.forEach(System.out::println);
            linkedPurchaseLists.forEach(session::save);

            session.getTransaction().commit();



        } finally {
            factory.close();
            session.close();
        }
    }
}
