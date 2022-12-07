import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Delivery extends JPanel{
    Object[][] data;
    String[] columnNames;
    String sqlQuery = "SELECT * FROM Delivery";

    public Delivery() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        columnNames = Main.sqlQueryFetchColumns(sqlQuery);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
