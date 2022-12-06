import java.sql.*;

public class Main {
    public static Connection cnx = null;
    public static void main(String[] args) {
        //Init Objects

        //Connect to SQL server
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to the MySQL server
            cnx = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/",
                    "root",
                    "password"
            );

            // Print the connection data
            System.out.println("Connected to MySQL Server version" + cnx.getMetaData().getDatabaseProductVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //call initializer function
        new Window();
    }
}


