import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Product extends JPanel{
    String sqlQuery = "SELECT * FROM Product";
    String[] columnNames;
    Object[][] data;

    public Product() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        columnNames = Main.sqlQueryFetchColumns(sqlQuery);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
