import javax.swing.*;
import java.awt.*;

public class createTablePanel extends JPanel {
    final JTable dataTable;
    public createTablePanel(Object[][] data, String[] columnNames){
        super(true);

        dataTable = new JTable(data, columnNames);
        dataTable.setFont(Window.mono12);
        dataTable.setGridColor(Color.BLACK);
        dataTable.setEnabled(false);
        dataTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        dataTable.getTableHeader().setFont(Window.f14);
        dataTable.getTableHeader().setForeground(new Color(80,80,80));
        dataTable.setSize(750, 300);
        scrollPane.setPreferredSize(new Dimension(750, 200));
        this.add(scrollPane);
    }
}
