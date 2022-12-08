import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delivery extends JPanel{
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
    JTextField trackingNum;
    JTextField trailerNum;
    JTextField employeeNum;
    JTextField businessID;
    JTextField wareNo;
    JTextField orderID;
    final String sqlQuery = "SELECT * FROM Delivery";

    public Delivery() throws SQLException {
        super(true);

        sortPrompt = new JLabel("Sort By:");
        sortPrompt.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
        deletePrompt = new JLabel("Delete row(trackingNum):");
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

        trackingNum = new JTextField("", 8);
        trailerNum = new JTextField("", 15);
        employeeNum = new JTextField("", 15);
        businessID = new JTextField("", 20);
        wareNo = new JTextField("", 10);
        orderID = new JTextField("", 10);

        removeButton = new JButton("Remove");
        removeNumber = new JTextField("", 5);

        trackingNum.setFont(Window.mono12);
        trailerNum.setFont(Window.mono12);
        employeeNum.setFont(Window.mono12);
        businessID.setFont(Window.mono12);
        wareNo.setFont(Window.mono12);
        orderID.setFont(Window.mono12);

        this.add(sortPrompt);
        this.add(sortBy);
        this.add(submitSort);

        this.add(table);
        this.add(trackingNum);
        this.add(trailerNum);
        this.add(employeeNum);
        this.add(businessID);
        this.add(wareNo);
        this.add(orderID);
        this.add(submitAdd);
        this.add(deletePrompt);
        this.add(removeNumber);
        this.add(removeButton);
        submitSort.addActionListener(e -> {
            try {
                dataTemp = Main.sqlQueryFetchTable(String.format("SELECT * FROM DELIVERY ORDER BY %s ASC;", sortBy.getSelectedItem().toString()));
                assert dataTemp != null;
                columnNames = TableManipulate.getColumnName(dataTemp);
                data = TableManipulate.getTableData(dataTemp);
                this.remove(table);
                table = new createTablePanel(data,columnNames);

                this.add(table);
                this.add(trackingNum);
                this.add(trailerNum);
                this.add(employeeNum);
                this.add(businessID);
                this.add(wareNo);
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
                PreparedStatement pstmt = Main.cnx.prepareStatement("INSERT INTO `delivery` (trackingNum, trailerNum, employeeNum, businessID, wareNo, orderID) VALUES (?, ?, ?, ?, ?, ?)");

                pstmt.setInt(1, Integer.parseInt(trackingNum.getText()));
                pstmt.setInt(2, Integer.parseInt(trailerNum.getText()));
                pstmt.setInt(3, Integer.parseInt(employeeNum.getText()));
                pstmt.setString(4, businessID.getText());
                pstmt.setString(5, wareNo.getText());
                pstmt.setString(6, orderID.getText());

                pstmt.executeUpdate();

                this.add(table);
                this.add(trackingNum);
                this.add(trailerNum);
                this.add(employeeNum);
                this.add(businessID);
                this.add(wareNo);
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
                PreparedStatement pstmt = Main.cnx.prepareStatement("DELETE FROM delivery WHERE trackingNum = ?");
                pstmt.setInt(1, Integer.parseInt(removeNumber.getText()));
                pstmt.executeUpdate();

                this.add(table);
                this.add(trackingNum);
                this.add(trailerNum);
                this.add(employeeNum);
                this.add(businessID);
                this.add(wareNo);
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
