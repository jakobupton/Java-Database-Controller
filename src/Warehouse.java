import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Warehouse extends JPanel{
    String sqlQuery = "SELECT * FROM Warehouse";
    String[] columnNames;
    Object[][] data;

    public Warehouse() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        columnNames = Main.sqlQueryFetchColumns(sqlQuery);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
