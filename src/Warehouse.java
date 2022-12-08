import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Warehouse extends JPanel{
    final String sqlQuery = "SELECT * FROM WAREHOUSE";
    String[] columnNames;
    Object[][] data;
    Object[][] dataTemp;

    JButton submitAdd;
    JButton removeButton;
    JButton submitSort;
    createTablePanel table;
    JLabel sortPrompt;
    JLabel deletePrompt;
    JTextField removeNumber;
    JTextField wareNo;
    JTextField warePhone;
    JTextField wareAddress;

    public Warehouse() throws SQLException {
        super(true);

        sortPrompt = new JLabel("Sort By:");
        sortPrompt.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
        deletePrompt = new JLabel("Delete row(wareNo):");
        deletePrompt.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));

        dataTemp = Main.sqlQueryFetchTable(sqlQuery);
        assert dataTemp != null;
        columnNames = TableManipulate.getColumnName(dataTemp);
        data = TableManipulate.getTableData(dataTemp);
        table = new createTablePanel(data, columnNames);

        submitSort = new JButton("UPDATE");
        submitSort.setBounds(700, 525, 80, 25);
        submitSort.setFont(Window.mono12);

        submitAdd = new JButton("Add");

        JComboBox sortBy = new JComboBox(columnNames);

        wareNo = new JTextField("", 8);
        warePhone = new JTextField("", 8);
        wareAddress = new JTextField("", 12);

        removeButton = new JButton("Remove");
        removeNumber = new JTextField("", 5);

        wareNo.setFont(Window.mono12);
        warePhone.setFont(Window.mono12);
        wareAddress.setFont(Window.mono12);

        this.add(sortPrompt);
        this.add(sortBy);
        this.add(submitSort);

        this.add(table);
        this.add(wareNo);
        this.add(warePhone);
        this.add(wareAddress);
        this.add(submitAdd);

        this.add(deletePrompt);
        this.add(removeNumber);
        this.add(removeButton);
        submitSort.addActionListener(e -> {
            try {
                dataTemp = Main.sqlQueryFetchTable(String.format("SELECT * FROM WAREHOUSE ORDER BY %s ASC;", sortBy.getSelectedItem().toString()));
                assert dataTemp != null;
                columnNames = TableManipulate.getColumnName(dataTemp);
                data = TableManipulate.getTableData(dataTemp);
                this.remove(table);
                table = new createTablePanel(data,columnNames);

                this.add(table);
                this.add(wareNo);
                this.add(warePhone);
                this.add(wareAddress);
                this.add(submitAdd);

                this.add(deletePrompt);
                this.add(removeNumber);
                this.add(removeButton);
            } catch (SQLException ex) {
            }
            table.updateUI();
            this.updateUI();
        });

        submitAdd.addActionListener(e -> {
            try{
                PreparedStatement pstmt = Main.cnx.prepareStatement("INSERT INTO `warehouse` (wareNo, warePhone, wareAddress) VALUES (?, ?, ?)");

                pstmt.setString(1, wareNo.getText());
                pstmt.setString(2, warePhone.getText());
                pstmt.setString(3, wareAddress.getText());
                pstmt.executeUpdate();

                this.add(table);
                this.add(wareNo);
                this.add(warePhone);
                this.add(wareAddress);
                this.add(submitAdd);

                this.add(deletePrompt);
                this.add(removeNumber);
                this.add(removeButton);
            }catch (SQLException ex){
            }
        });

        removeButton.addActionListener(e -> {
            try{
                PreparedStatement pstmt = Main.cnx.prepareStatement("DELETE FROM warehouse WHERE wareNo = ?");
                pstmt.setInt(1, Integer.parseInt(removeNumber.getText()));
                pstmt.executeUpdate();

                this.add(table);
                this.add(wareNo);
                this.add(warePhone);
                this.add(wareAddress);
                this.add(submitAdd);

                this.add(deletePrompt);
                this.add(removeNumber);
                this.add(removeButton);


            }catch (SQLException ex){
                System.err.println("Got an exception! ");
                System.err.println(ex.getMessage());
            }
        });

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
