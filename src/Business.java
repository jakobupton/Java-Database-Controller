import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Business extends JPanel{
    Object[][] data = null;
    String[] columnNames = {"businessID", "businessName", "businessAddress", "businessEmail", "businessPhone"};
    String sqlFetch = "SELECT * FROM Business";
    public Business() throws SQLException {
        super(true);

        data = Main.sqlQueryFetchTable(sqlFetch);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}
