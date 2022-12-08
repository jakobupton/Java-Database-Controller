import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Invoice extends JPanel {
    String[] columnNames;
    final String sqlQuery = "SELECT * FROM Invoice";
    Object[][] data;
    Object[][] dataTemp;

    JButton submitAdd;
    JButton removeButton;
    JButton submitSort;
    createTablePanel table;
    JLabel sortPrompt;
    JLabel deletePrompt;
    JTextField removeNumber;
    JTextField invoiceID;
    JTextField businessID;
    JTextField orderID;

    public Invoice() throws SQLException {
        super(true);

        sortPrompt = new JLabel("Sort By:");
        sortPrompt.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
        deletePrompt = new JLabel("Delete row(invoiceID):");
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

        invoiceID = new JTextField("", 8);
        businessID = new JTextField("", 8);
        orderID = new JTextField("", 12);

        removeButton = new JButton("Remove");
        removeNumber = new JTextField("", 5);

        invoiceID.setFont(Window.mono12);
        businessID.setFont(Window.mono12);
        orderID.setFont(Window.mono12);

        this.add(sortPrompt);
        this.add(sortBy);
        this.add(submitSort);

        this.add(table);
        this.add(invoiceID);
        this.add(businessID);
        this.add(orderID);
        this.add(submitAdd);

        this.add(deletePrompt);
        this.add(removeNumber);
        this.add(removeButton);
        submitSort.addActionListener(e -> {
            try {
                dataTemp = Main.sqlQueryFetchTable(String.format("SELECT * FROM INVOICE ORDER BY %s ASC;", sortBy.getSelectedItem().toString()));
                assert dataTemp != null;
                columnNames = TableManipulate.getColumnName(dataTemp);
                data = TableManipulate.getTableData(dataTemp);
                this.remove(table);
                table = new createTablePanel(data,columnNames);

                this.add(table);
                this.add(invoiceID);
                this.add(businessID);
                this.add(orderID);
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
                PreparedStatement pstmt = Main.cnx.prepareStatement("INSERT INTO `invoice` (invoiceID, businessID, orderID) VALUES (?, ?, ?)");

                pstmt.setString(1, invoiceID.getText());
                pstmt.setString(2, businessID.getText());
                pstmt.setString(3, orderID.getText());
                pstmt.executeUpdate();

                this.add(table);
                this.add(invoiceID);
                this.add(businessID);
                this.add(orderID);
                this.add(submitAdd);

                this.add(deletePrompt);
                this.add(removeNumber);
                this.add(removeButton);
            }catch (SQLException ex){
            }
        });

        removeButton.addActionListener(e -> {
            try{
                PreparedStatement pstmt = Main.cnx.prepareStatement("DELETE FROM invoice WHERE invoiceID = ?");
                pstmt.setInt(1, Integer.parseInt(removeNumber.getText()));
                pstmt.executeUpdate();

                this.add(table);
                this.add(invoiceID);
                this.add(businessID);
                this.add(orderID);
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

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
