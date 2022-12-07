import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Truck extends JPanel{
    String sqlQuery = "SELECT * FROM Truck";
    String[] columnNames;
    Object[][] data;

    public Truck() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        columnNames = Main.sqlQueryFetchColumns(sqlQuery);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
