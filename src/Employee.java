import javax.swing.*;
import java.awt.*;

public class Employee extends JPanel{
    static int empNum = 0;
    static String name = "";
    static String position = "";
    static String phone = "";
    static int salary = 0;
    static String address = "";
    static String startDate = "";
    static String assignedTruckPlate = "";
    static int empManager;

    public Employee(){

        super(true);

        this.setBackground(new Color(80, 80, 80));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing7", this.getWidth()/2, 50, Window.f30);
    }
}
