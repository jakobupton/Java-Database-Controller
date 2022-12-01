import javax.swing.*;
import java.awt.*;

public final class Window {

    static Font f30 = new Font("Leelawadee", Font.PLAIN, 30);
    public Window(){
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

    public static void drawCenteredString(Graphics g, String text, int x, int y, Font ff){
        FontMetrics metrics = g.getFontMetrics(ff);
        x -= (metrics.stringWidth(text)) / 2;
        g.setFont(ff);
        g.drawString(text, x, y);
    }

}

class WindowPaint extends JPanel {
    Dimension preferredSize = new Dimension(800,600);
    private JPanel masterPanel;
    private JTabbedPane tabbedPanel;
    public WindowPaint() {
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
        tabbedPanel.addTab("Home", new Home());
        tabbedPanel.addTab("Warehouses", new Warehouse());
        tabbedPanel.addTab("Deliveries", new Delivery());
        tabbedPanel.addTab("Invoices", new Invoice());
        tabbedPanel.addTab("Trucks", new Truck());
        tabbedPanel.addTab("Products", new Product());
        tabbedPanel.addTab("Businesses", new Business());
        tabbedPanel.addTab("Employees", new Employee());
        tabbedPanel.addTab("Orders", new OrderContents());

        this.add(tabbedPanel, BorderLayout.CENTER);
    }
}
