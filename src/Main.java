import java.sql.*;


//NEEDS MySQL Connector 8.0.31 to connect to server
public class Main {
    public static Connection cnx = null;

    //Fetches the data from a given query.
    //Row 0 is the Columns names
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

        data = new Object[numberOfRows+1][numberOfColumns];

        //set first Row to name of each column
        for(int i = 0; i < numberOfColumns; i++){
            data[0][i] = rs.getMetaData().getColumnLabel(i+1);
        }

        int i = 1;
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

        //enter the ip and database of your own MySQL server here
        String url = "jdbc:mysql://localhost:3306/databaseName";
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


