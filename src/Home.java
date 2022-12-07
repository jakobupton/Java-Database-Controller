import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Home extends JPanel {
    static JEditorPane textField;
    JLabel prompt;

    Object[][] data = null;
    String[] test = {"wareNo", "warePhone", "wareAddress"};
    public Home() {
        super(true);

        this.setLayout(null);

        if(data != null) {
            this.add(new createTablePanel(data, test));
        }
        prompt = new JLabel("Manual Query");
        prompt.setFont(new Font("Roboto", Font.PLAIN, 20));
        prompt.setBounds(400, 400 - prompt.getFont().getSize() - 2, 400, prompt.getFont().getSize() + 2);
        textField = new JEditorPane();
        textField.setAutoscrolls(true);
        textField.setBounds(400, 400, 400, 125);
        textField.setFont(new Font("Roboto Mono", Font.PLAIN, 12));
        JButton submit = new JButton("Submit");
        submit.setBounds(700, 525, 80, 25);
        this.add(prompt);
        this.add(textField,BorderLayout.CENTER);
        this.add(submit);
        submit.addActionListener(e -> {
            try {
                data = Main.sqlQueryFetchTable(Home.textField.getText());
                this.updateUI();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        //TODO
        // Home.textField.getText() into SQL statement and run it, on submit

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        Window.drawCenteredString(g, "yabbadabba do" , 300, 300, Window.f30);

    }
}
