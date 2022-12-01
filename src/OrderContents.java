import javax.swing.*;
import java.awt.*;

public class OrderContents extends JPanel{
    static String id = "";
    static String productID = "";
    static int quantity = 0;
    private static JPanel orderContentsTab;

    public OrderContents(){
        super(true);

        this.setBackground(new Color(80, 80, 80));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing8", this.getWidth()/2, 50, Window.f30);
    }
}
