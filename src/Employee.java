import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Employee extends JPanel{
    String[] columnNames;
    Object [][] data;
    String sqlQuery = "select * from employee";


    public Employee() throws SQLException {

        super(true);
        data = Main.sqlQueryFetchTable(sqlQuery);
        columnNames = Main.sqlQueryFetchColumns(sqlQuery);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
