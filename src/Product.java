import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product extends JPanel{
    final String sqlQuery = "SELECT * FROM Product";
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

    JTextField productSKU;
    JTextField weight;
    JTextField productName;
    JTextField price;
    JTextField dimensions;

    public Product() throws SQLException {
        super(true);

        sortPrompt = new JLabel("Sort By:");
        sortPrompt.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
        deletePrompt = new JLabel("Delete row(productSKU):");
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

        productSKU = new JTextField("", 8);
        weight = new JTextField("", 15);
        productName = new JTextField("", 15);
        price = new JTextField("", 20);
        dimensions = new JTextField("", 10);

        removeButton = new JButton("Remove");
        removeNumber = new JTextField("", 5);

        productSKU.setFont(Window.mono12);
        weight.setFont(Window.mono12);
        productName.setFont(Window.mono12);
        price.setFont(Window.mono12);
        dimensions.setFont(Window.mono12);

        this.add(sortPrompt);
        this.add(sortBy);
        this.add(submitSort);

        this.add(table);
        this.add(productSKU);
        this.add(weight);
        this.add(productName);
        this.add(price);
        this.add(dimensions);

        this.add(submitAdd);
        this.add(deletePrompt);
        this.add(removeNumber);
        this.add(removeButton);
        submitSort.addActionListener(e -> {
            try {
                dataTemp = Main.sqlQueryFetchTable(String.format("SELECT * FROM PRODUCT ORDER BY %s ASC;", sortBy.getSelectedItem().toString()));
                assert dataTemp != null;
                columnNames = TableManipulate.getColumnName(dataTemp);
                data = TableManipulate.getTableData(dataTemp);
                this.remove(table);
                table = new createTablePanel(data,columnNames);

                this.add(table);
                this.add(productSKU);
                this.add(weight);
                this.add(productName);
                this.add(price);
                this.add(dimensions);

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
                PreparedStatement pstmt = Main.cnx.prepareStatement("INSERT INTO `product` (productSKU, weight, productName, price, dimensions) VALUES (?, ?, ?, ?, ?)");

                pstmt.setString(1, productSKU.getText());
                pstmt.setInt(2, Integer.parseInt(weight.getText()));
                pstmt.setString(3, productName.getText());
                pstmt.setInt(4, Integer.parseInt(price.getText()));
                pstmt.setString(5, dimensions.getText());

                pstmt.executeUpdate();

                this.add(table);
                this.add(productSKU);
                this.add(weight);
                this.add(productName);
                this.add(price);
                this.add(dimensions);

                this.add(submitAdd);
                this.add(deletePrompt);
                this.add(removeNumber);
                this.add(removeButton);
            }catch (SQLException ex){
            }
        });

        removeButton.addActionListener(e -> {
            try{
                PreparedStatement pstmt = Main.cnx.prepareStatement("DELETE FROM PRODUCT WHERE productSKU = ?");
                pstmt.setString(1, productSKU.getText());
                pstmt.executeUpdate();

                this.add(table);
                this.add(productSKU);
                this.add(weight);
                this.add(productName);
                this.add(price);
                this.add(dimensions);

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
