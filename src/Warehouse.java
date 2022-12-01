import javax.swing.*;
import java.awt.*;

public class Warehouse extends JPanel{
    static String wareNo = "";
    static String warePhone = "";
    static String wareAddress = "";
    private static JPanel warehouseTab;

    public Warehouse(){
        super(true);

        this.setBackground(new Color(80, 80, 80));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing1", this.getWidth() / 2, 50, Window.f30);
    }
}
