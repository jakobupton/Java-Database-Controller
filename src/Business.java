import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Business extends JPanel{
    Object[][] data;
    Object[][] dataTemp;
    String[] columnNames;

    JButton submitAdd;
    JButton removeButton;
    JButton submitSort;
    createTablePanel table;
    JLabel sortPrompt;
    JLabel deletePrompt;
    JTextField removeNumber;
    JTextField businessID;
    JTextField businessName;
    JTextField businessAddress;
    JTextField businessEmail;
    JTextField businessPhone;
    final String sqlQuery = "SELECT * FROM Business";
    public Business() throws SQLException {
        super(true);

        sortPrompt = new JLabel("Sort By:");
        sortPrompt.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
        deletePrompt = new JLabel("Delete row(businessID):");
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

        businessID = new JTextField("", 8);
        businessName = new JTextField("", 15);
        businessAddress = new JTextField("", 15);
        businessEmail = new JTextField("", 20);
        businessPhone = new JTextField("", 10);

        removeButton = new JButton("Remove");
        removeNumber = new JTextField("", 5);

        businessID.setFont(Window.mono12);
        businessName.setFont(Window.mono12);
        businessAddress.setFont(Window.mono12);
        businessEmail.setFont(Window.mono12);
        businessPhone.setFont(Window.mono12);

        this.add(sortPrompt);
        this.add(sortBy);
        this.add(submitSort);

        this.add(table);
        this.add(businessID);
        this.add(businessName);
        this.add(businessAddress);
        this.add(businessEmail);
        this.add(businessPhone);
        this.add(submitAdd);

        this.add(deletePrompt);
        this.add(removeNumber);
        this.add(removeButton);
        submitSort.addActionListener(e -> {
            try {
                dataTemp = Main.sqlQueryFetchTable(String.format("SELECT * FROM BUSINESS ORDER BY %s ASC;", sortBy.getSelectedItem().toString()));
                assert dataTemp != null;
                columnNames = TableManipulate.getColumnName(dataTemp);
                data = TableManipulate.getTableData(dataTemp);
                this.remove(table);
                table = new createTablePanel(data,columnNames);

                this.add(table);
                this.add(businessID);
                this.add(businessName);
                this.add(businessAddress);
                this.add(businessEmail);
                this.add(businessPhone);
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
                PreparedStatement pstmt = Main.cnx.prepareStatement("INSERT INTO `business` (businessID, businessName, businessAddress, businessEmail, businessPhone) VALUES (?, ?, ?, ?, ?)");

                pstmt.setString(1, businessID.getText());
                pstmt.setString(2, businessName.getText());
                pstmt.setString(3, businessAddress.getText());
                pstmt.setString(4, businessEmail.getText());
                pstmt.setString(5, businessPhone.getText());
                pstmt.executeUpdate();

                this.add(table);
                this.add(businessID);
                this.add(businessName);
                this.add(businessAddress);
                this.add(businessEmail);
                this.add(businessPhone);
                this.add(submitAdd);

                this.add(deletePrompt);
                this.add(removeNumber);
                this.add(removeButton);
            }catch (SQLException ex){
            }
        });

        removeButton.addActionListener(e -> {
            try{
                PreparedStatement pstmt = Main.cnx.prepareStatement("DELETE FROM business WHERE businessID = ?");
                pstmt.setString(1, removeNumber.getText());
                pstmt.executeUpdate();

                this.add(table);
                this.add(businessID);
                this.add(businessName);
                this.add(businessAddress);
                this.add(businessEmail);
                this.add(businessPhone);

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
