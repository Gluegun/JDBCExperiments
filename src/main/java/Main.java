import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class Main {

    public static String url = "jdbc:mysql://localhost:3306/skillboxcorrect?useUnicode=true&serverTimezone=Europe/Moscow&characterEncoding=UTF-8";
    public static String user = "root";
    public static String pass = "testtest";


    public static void main(String[] args) {


        SessionFactory sessionFactory = createSessionFactory();

        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, 1);
        System.out.println(course.getName() + " " + course.getDescription() + " " + course.getPrice() + " " + course.getType());

        Student student = session.get(Student.class, 2);

        System.out.printf("Студент id:%d\nИмя: %s\nВозраст: %d\n", student.getId(), student.getName(), student.getAge());

        sessionFactory.close();

    }

    public static SessionFactory createSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        return sessionFactory;

    }
}
