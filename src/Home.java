import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Home extends JPanel {
    static JEditorPane textField;
    JLabel prompt;

    String[] columnNames;
    Object[][] data;
    Object[][] dataTemp;
    static createTablePanel table;
    final String defaultQuery = ("SELECT wareNo, warePhone, wareAddress\n" +
            "\tFROM Warehouse\n" +
            "\tWHERE wareNo >= 185;");
    public Home() throws SQLException {

        super(true);

        //table showing database info
        dataTemp = Main.sqlQueryFetchTable("SELECT table_name\n" +
                "FROM information_schema.tables\n" +
                "WHERE table_type='BASE TABLE' AND table_schema = 'comp230project'");
        assert dataTemp != null;
        columnNames = TableManipulate.getColumnName(dataTemp);
        data = TableManipulate.getTableData(dataTemp);
        this.add(new createTablePanel(data, new String[]{"comp230Project"}));

        //this.setLayout(null);
        prompt = new JLabel("Manual Query");
        prompt.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
        textField = new JEditorPane();
        textField.setAutoscrolls(true);
        textField.setBounds(400, 200, 400, 125);
        textField.setText(defaultQuery);
        textField.setFont(Window.mono12);
        JButton submit = new JButton("Submit");
        submit.setBounds(700, 525, 80, 25);
        submit.setFont(Window.f14);
        table = new createTablePanel(data, columnNames);
        this.add(prompt);
        this.add(textField,BorderLayout.CENTER);
        this.add(submit);
        submit.addActionListener(e -> {
            try {
                dataTemp = Main.sqlQueryFetchTable(textField.getText());
                assert dataTemp != null;
                columnNames = TableManipulate.getColumnName(dataTemp);
                data = TableManipulate.getTableData(dataTemp);
                this.remove(table);
                table = new createTablePanel(data,columnNames);
                this.add(table);
            } catch (SQLException ex) {
                textField.setText("Invalid Query!");
            }
        textField.updateUI();
        this.updateUI();
        });

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
