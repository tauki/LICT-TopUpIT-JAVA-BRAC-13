import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        final String
                DB_URL  = "jdbc:mysql://localhost:3306/brac?zeroDateTimeBehavior=convertToNull",
                DB_USER = "root",
                DB_PASS = "";

        Driver driver = new com.mysql.jdbc.Driver();
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

        System.out.println("Connected...");
        Statement stmt = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );

        String qry = "SELECT * FROM employees WHERE MANAGER_ID=? AND DEPARTMENT_ID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(qry);

        Scanner keyboard = new Scanner(System.in);
        preparedStatement.setInt(1, Integer.parseInt(keyboard.nextLine()));
        preparedStatement.setInt(2, Integer.parseInt(keyboard.nextLine()));

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            int ID = resultSet.getInt(1);
            String FIRST_NAME = resultSet.getString(2);
            String LAST_NAME = resultSet.getString(3);
            String EMAIL = resultSet.getString(4);
            String PHONE_NUMBER = resultSet.getString(5);
            Timestamp HIRE_DATE = resultSet.getTimestamp(6);
            String JOB_ID = resultSet.getString(7);
            int SALARY = resultSet.getInt(8);
            int COMMISSION_PCT = resultSet.getInt(9);
            int MANAGER_ID = resultSet.getInt(10);
            int DEPARTMENT_ID = resultSet.getInt(11);
            System.out.println(
                    ID + " "
                    + FIRST_NAME + " "
                    + LAST_NAME + " "
                    + EMAIL + " "
                    + PHONE_NUMBER + " "
                    + HIRE_DATE + " "
                    + JOB_ID + " "
                    + SALARY + " "
                    + COMMISSION_PCT + " "
                    + MANAGER_ID + " "
                    + DEPARTMENT_ID
            );
        }
    }
}