import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

    public static String url = "jdbc:mysql://localhost:3306/skillboxcorrect?useUnicode=true&serverTimezone=Europe/Moscow&characterEncoding=UTF-8";
    public static String user = "root";
    public static String pass = "testtest";


    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT COUNT(distinct monthname(subscription_date)) as counts FROM purchaselist ORDER BY month(subscription_date)");
            int amountOfMonths = 0;
            while (resultSet.next()) {
                amountOfMonths = resultSet.getInt(1);
            }
            System.out.println(amountOfMonths);

            for (int i = 0; i <= amountOfMonths; i++) {
                resultSet = statement.executeQuery("SELECT COUNT(*), course_name, monthname(subscription_date), " +
                        "subscription_date FROM purchaselist " +
                        "WHERE MONTH(subscription_date) = '" + i + "' GROUP BY course_name;");


                while (resultSet.next()) {
                    String courseName = resultSet.getString("course_name");
                    String month = (resultSet.getString("monthname(subscription_date)"));
                    int amountOfPurchases = resultSet.getInt("COUNT(*)");

                    System.out.printf("Курс %s был куплен %d раз в %s месяце\n", courseName, amountOfPurchases, month);

                }
            }

            resultSet = statement.executeQuery("SELECT course_name, COUNT(*)/" + amountOfMonths + " as average_amount_of_purchases FROM purchaselist GROUP BY course_name");
            while (resultSet.next()) {

                String courseName = resultSet.getString("course_name");
                double amountOfPurchases = resultSet.getDouble("average_amount_of_purchases");

                System.out.printf("В среднем курс %s покупают %f раз в месяц\n", courseName, amountOfPurchases);


            }

            connection.close();
            statement.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
