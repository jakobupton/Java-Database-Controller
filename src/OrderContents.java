import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

@SuppressWarnings("SpellCheckingInspection")
public class OrderContents extends JPanel{
    final String sqlQuery = "SELECT * FROM ordercontents";
    String[] columnNames;
    Object[][] data;
    Object[][] dataTemp;

    public OrderContents() throws SQLException {
        super(true);

        dataTemp = Main.sqlQueryFetchTable(sqlQuery);
        assert dataTemp != null;
        columnNames = TableManipulate.getColumnName(dataTemp);
        data = TableManipulate.getTableData(dataTemp);
        this.add(new createTablePanel(data, columnNames));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
