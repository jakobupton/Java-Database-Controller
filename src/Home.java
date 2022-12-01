import javax.swing.*;
import java.awt.*;

public class Home extends JPanel {
    JTable table1 = new JTable();
    public Home() {
        super(true);

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing6", this.getWidth()/2, 50, Window.f30);
    }
}
