import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public final class Window {
    static final Font f14 = new Font("Roboto Condensed", Font.PLAIN, 14);
    static final Font mono12 = new Font("Roboto Mono", Font.PLAIN, 12);
    public Window() throws SQLException {
        JFrame mainWindow = new JFrame("COMP230 Project");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.add(new WindowPaint());
        mainWindow.pack();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setBackground(new Color(80,80,80));
        mainWindow.setVisible(true);
        mainWindow.setResizable(false);
        mainWindow.setPreferredSize(new Dimension(600, 600));
    }
}

class WindowPaint extends JPanel {
    final JTabbedPane tabbedPanel;
    public WindowPaint() throws SQLException {
        super(true);

        setOpaque(true);

        //tabs to attach each panel to
        tabbedPanel = new JTabbedPane();
        tabbedPanel.setFont(new Font("Roboto", Font.PLAIN, 16));
        tabbedPanel.setForeground(new Color(80, 80, 80));
        tabbedPanel.setBackground(Color.WHITE);
        tabbedPanel.setPreferredSize(new Dimension(800, 600));
        tabbedPanel.setFocusable(false);

        //panels for each title
        if(Main.cnx.isValid(100)) {
            tabbedPanel.addTab("Home", new Home());
            tabbedPanel.addTab("Warehouses", new Warehouse());
            tabbedPanel.addTab("Deliveries", new Delivery());
            tabbedPanel.addTab("Invoices", new Invoice());
            tabbedPanel.addTab("Trucks", new Truck());
            tabbedPanel.addTab("Products", new Product());
            tabbedPanel.addTab("Businesses", new Business());
            tabbedPanel.addTab("Employees", new Employee());
            //tabbedPanel.addTab("Orders", new OrderContents());
            this.add(tabbedPanel);
        }
    }
}
