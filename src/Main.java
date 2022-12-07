import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Connection cnx = null;

    public static Object[][] sqlQueryFetchTable(String query) throws SQLException {
        Object[][] data = null;
        Statement stmt = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(query);
        int numberOfRows = 0;
        try{
            rs.last();
            numberOfRows = rs.getRow();
            rs.beforeFirst();
        }catch(Exception e){
            return data;
        }
        int numberOfColumns = rs.getMetaData().getColumnCount();
        data = new Object[numberOfRows][numberOfColumns];
        int i = 0;
        while(rs.next()){
            for(int j = 0; j < numberOfColumns; j++){
                data[i][j] = rs.getString(j+1);
            }
            i++;
        }
        return data;
    }
    public static void main(String[] args) throws SQLException {
        //Init Objects
        String url = "jdbc:mysql://96.48.33.210:3306/comp230project";
        String username = "root";
        String password = "password";

        //Connect to SQL server
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the MySQL server
            cnx = DriverManager.getConnection(url, username, password);

            // Print the connection data to console
            System.out.println("Connected to MySQL Server version " + cnx.getMetaData().getDatabaseProductVersion() + " @ " + url + " with user " + username );
        } catch (Exception e) {
            e.printStackTrace();
        }

        //call initializer function
        new Window();
    }
}


