import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Invoice extends JPanel {
    String[] columnNames = {"invoiceID", "businessID", "orderID"};
    String sqlQuery = "SELECT * FROM Invoice";
    Object[][] data = null;

    public Invoice() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        this.add(new createTablePanel(data, columnNames));

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
