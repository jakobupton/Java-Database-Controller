import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Warehouse extends JPanel{
    String sqlQuery = "SELECT * FROM Warehouse";
    String[] columnNames = {"wareNo", "warePhone", "wareAddress"};
    Object[][] data = null;

    public Warehouse() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
