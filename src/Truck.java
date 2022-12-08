import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Truck extends JPanel{
    final String sqlQuery = "SELECT * FROM Truck";
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

    JTextField plateNo;
    JTextField trailerNo;
    JTextField maxLoad;
    JTextField truckModel;

    public Truck() throws SQLException {
        super(true);
        sortPrompt = new JLabel("Sort By:");
        sortPrompt.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
        deletePrompt = new JLabel("Delete row(plateNo):");
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

        plateNo = new JTextField("", 8);
        trailerNo = new JTextField("", 15);
        maxLoad = new JTextField("", 15);
        truckModel = new JTextField("", 20);

        removeButton = new JButton("Remove");
        removeNumber = new JTextField("", 5);

        plateNo.setFont(Window.mono12);
        trailerNo.setFont(Window.mono12);
        maxLoad.setFont(Window.mono12);
        truckModel.setFont(Window.mono12);

        this.add(sortPrompt);
        this.add(sortBy);
        this.add(submitSort);

        this.add(table);
        this.add(plateNo);
        this.add(trailerNo);
        this.add(maxLoad);
        this.add(truckModel);

        this.add(submitAdd);
        this.add(deletePrompt);
        this.add(removeNumber);
        this.add(removeButton);
        submitSort.addActionListener(e -> {
            try {
                dataTemp = Main.sqlQueryFetchTable(String.format("SELECT * FROM TRUCK ORDER BY %s ASC;", sortBy.getSelectedItem().toString()));
                assert dataTemp != null;
                columnNames = TableManipulate.getColumnName(dataTemp);
                data = TableManipulate.getTableData(dataTemp);
                this.remove(table);
                table = new createTablePanel(data,columnNames);

                this.add(table);
                this.add(plateNo);
                this.add(trailerNo);
                this.add(maxLoad);
                this.add(truckModel);

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
                PreparedStatement pstmt = Main.cnx.prepareStatement("INSERT INTO `truck` (plateNo, trailerNo, maxLoad, truckModel) VALUES (?, ?, ?, ?)");

                pstmt.setString(1, plateNo.getText());
                pstmt.setInt(2, Integer.parseInt(trailerNo.getText()));
                pstmt.setInt(3, Integer.parseInt(maxLoad.getText()));
                pstmt.setString(4, maxLoad.getText());

                pstmt.executeUpdate();

                this.add(table);
                this.add(plateNo);
                this.add(trailerNo);
                this.add(maxLoad);
                this.add(truckModel);

                this.add(submitAdd);
                this.add(deletePrompt);
                this.add(removeNumber);
                this.add(removeButton);
            }catch (SQLException ex){
            }
        });

        removeButton.addActionListener(e -> {
            try{
                PreparedStatement pstmt = Main.cnx.prepareStatement("DELETE FROM TRUCK WHERE plateNo = ?");
                pstmt.setString(1, plateNo.getText());
                pstmt.executeUpdate();

                this.add(table);
                this.add(plateNo);
                this.add(trailerNo);
                this.add(maxLoad);
                this.add(truckModel);

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
