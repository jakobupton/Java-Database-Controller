import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Invoice extends JPanel {
    String[] columnNames;
    String sqlQuery = "SELECT * FROM Invoice";
    Object[][] data;

    public Invoice() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        columnNames = Main.sqlQueryFetchColumns(sqlQuery);
        this.add(new createTablePanel(data, columnNames));

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
