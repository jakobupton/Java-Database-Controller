import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class OrderContents extends JPanel{
    String sqlQuery = "SELECT * FROM ordercontents";
    String[] columnNames = {"orderID", "productID", "quantity"};
    Object[][] data = null;

    public OrderContents() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
