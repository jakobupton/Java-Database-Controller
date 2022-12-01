import javax.swing.*;
import java.awt.*;

public class Truck extends JPanel{
    static String plateNo = "";
    static int trailerNo = 0;
    static int maxLoad = 0;
    static String model = "";
    private static JPanel truckTab;

    public Truck(){
        super(true);

        this.setBackground(new Color(80, 80, 80));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing4", this.getWidth()/2, 50, Window.f30);
    }

}
