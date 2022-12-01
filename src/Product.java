import javax.swing.*;
import java.awt.*;

public class Product extends JPanel{
    static String sku = "";
    static int weight = 0;
    static String name = "";
    static int price = 0;
    static String dimensions = "";
    private static JPanel productTab;

    public Product(){
        super(true);

        this.setBackground(new Color(80, 80, 80));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing5", this.getWidth()/2, 50, Window.f30);
    }
}
