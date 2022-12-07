import javax.swing.*;
import java.awt.*;

public class createTablePanel extends JPanel {
    JTable dataTable;
    public createTablePanel(Object[][] data, String[] columnNames){
        super(true);

        dataTable = new JTable(data, columnNames);
        dataTable.setFont(new Font("Roboto Mono", Font.PLAIN, 10));
        dataTable.setGridColor(Color.BLACK);
        dataTable.setEnabled(false);
        dataTable.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        dataTable.getTableHeader().setFont(Window.f30);
        dataTable.getTableHeader().setForeground(new Color(80,80,80));
        dataTable.setSize(750, 150);
        scrollPane.setPreferredSize(new Dimension(750, 100));
        this.setBorder(BorderFactory.createEmptyBorder(400,0 ,100 , 0));
        this.add(scrollPane);
    }
}
