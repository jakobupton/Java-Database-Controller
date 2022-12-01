import javax.swing.*;
import java.awt.*;

public class Invoice extends JPanel {
    static String id = "";
    static String businessID = "";
    static String orderID = "";
    private static JPanel invoiceTab;

    public Invoice(){
        super(true);

        this.setBackground(new Color(80, 80, 80));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing3", this.getWidth()/2, 50, Window.f30);
    }
}
