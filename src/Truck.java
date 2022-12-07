import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Truck extends JPanel{
    String sqlQuery = "SELECT * FROM Truck";
    String[] columnNames = {"plateNo", "trailerNo", "maxLoad", "truckModel"};
    Object[][] data = null;

    public Truck() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
