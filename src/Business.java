import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Business extends JPanel{
    Object[][] data;
    String[] columnNames;
    String sqlQuery = "SELECT * FROM Business";
    public Business() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlQuery);
        columnNames = Main.sqlQueryFetchColumns(sqlQuery);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}
