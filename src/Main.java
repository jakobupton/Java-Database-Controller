import java.sql.*;

public class Main {
    public static Connection cnx = null;

    //Could have made the first element of the table the column names and then splice that off to make tables, but I'm lazy
    //Fetches the column names of a given query.
    //Ex. "SELECT * FROM WAREHOUSE" returns ["wareNo", "warePhone", "wareAddress"]
    public static String[] sqlQueryFetchColumns(String query) throws SQLException{
        String[] columnNames;
        Statement stmt = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(query);

        int numberOfColumns = rs.getMetaData().getColumnCount();
        columnNames = new String[numberOfColumns];

        for(int i = 0; i < numberOfColumns; i++){
            columnNames[i] = rs.getMetaData().getColumnLabel(i+1);
        }

        return columnNames;
    }

    //Fetches the data from a given query.
    //returns in form of 2D Object Array with each row being the first index and every column being the second index
    public static Object[][] sqlQueryFetchTable(String query) throws SQLException {
        Object[][] data;
        Statement stmt = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(query);
        int numberOfRows;
        try{
            rs.last();
            numberOfRows = rs.getRow();
            rs.beforeFirst();
        }catch(Exception e){
            return null;
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


