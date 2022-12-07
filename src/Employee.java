import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Employee extends JPanel{
    String[] columnNames = {"employeeNum", "fullName", "empPosition", "empPhone", "empSalary", "empAddress", "empStartDate", "assignedTruckPlate", "empManager"};
    Object [][] data = null;
    String sqlFetch = "select * from employee";


    public Employee() throws SQLException {

        super(true);
        data = Main.sqlQueryFetchTable(sqlFetch);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
