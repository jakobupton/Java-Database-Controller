import javax.swing.*;
import java.awt.*;

public class Delivery extends JPanel{
    static int trackingNum = 0;
    static int trailerNum = 0;
    static int employeeNum = 0;
    static String businessID = "";
    static String wareNo = "";
    static String orderID = "";
    private Color tabColor;


    public Delivery(){
        super(true);

        this.setBackground(new Color(80, 80, 80));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing2", this.getWidth()/2, 50, Window.f30);
    }




}
