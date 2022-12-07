import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Delivery extends JPanel{
    Object[][] data = {{}};
    String[] columnNames = {"trackingNum", "trailerNum", "employeeNum", "businessID", "wareNo", "orderID"};
    String sqlQuery = "SELECT * FROM Delivery";

    public Delivery() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        if (data.length > 0 && columnNames.length > 0){
            this.add(new createTablePanel(data, columnNames));
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
