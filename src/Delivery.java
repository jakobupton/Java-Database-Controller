import javax.swing.*;
import java.awt.*;

public class Delivery extends JPanel{
    Object[][] data = {{}};
    String[] columnNames = {};

    public Delivery(){
        super(true);
        if (data.length > 0 && columnNames.length > 0){
            this.add(new createTablePanel(data, columnNames));
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing2", this.getWidth()/2, 50, Window.f30);
    }




}
