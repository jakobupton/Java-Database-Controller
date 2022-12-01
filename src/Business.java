import javax.swing.*;
import java.awt.*;

public class Business extends JPanel{
    static String id = "";
    static String name = "";
    static String address = "";
    static String email = "";
    static String phone = "";
    public Business(){
        super(true);

        this.setBackground(new Color(80, 80, 80));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing6", this.getWidth()/2, 50, Window.f30);
    }

}
