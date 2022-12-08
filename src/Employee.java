import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Employee extends JPanel{
    Object [][] dataTemp;
    Object [][] data;
    String[] columnNames;
    final String sqlQuery = "select * from employee";
    createTablePanel table;
    JLabel sortPrompt;
    JLabel deletePrompt;

    //for adding people;
    JTextField employeeNum;
    JTextField fullName;
    JTextField empPosition;
    JTextField empPhone;
    JTextField empSalary;
    JTextField empAddress;
    JTextField empStartDate;
    JTextField assignedTruckPlate;
    JTextField empManager;
    JTextField removeNumber;
    JButton submitAdd;
    JButton removeButton;
    JButton submitSort;


    public Employee() throws SQLException {
        super(true);

        sortPrompt = new JLabel("Sort By:");
        sortPrompt.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
        deletePrompt = new JLabel("Delete row(employeeNum):");
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

        employeeNum = new JTextField("", 4);
        fullName = new JTextField("", 11);
        empPosition = new JTextField("", 7);
        empPhone = new JTextField("", 12);
        empSalary  = new JTextField("", 8);
        empAddress = new JTextField("", 14);
        empStartDate = new JTextField("", 10);
        assignedTruckPlate = new JTextField("",7);
        empManager = new JTextField("", 4);


        removeButton = new JButton("Remove");
        removeNumber = new JTextField("", 5);



        employeeNum.setFont(Window.mono12);
        fullName.setFont(Window.mono12);
        empPosition.setFont(Window.mono12);
        empPhone.setFont(Window.mono12);
        empSalary.setFont(Window.mono12);
        empAddress.setFont(Window.mono12);
        empStartDate.setFont(Window.mono12);
        assignedTruckPlate.setFont(Window.mono12);
        empManager.setFont(Window.mono12);
        this.add(sortPrompt);
        this.add(sortBy);
        this.add(submitSort);


        this.add(table);
        this.add(employeeNum);
        this.add(fullName);
        this.add(empPosition);
        this.add(empPhone);
        this.add(empSalary);
        this.add(empAddress);
        this.add(empStartDate);
        this.add(assignedTruckPlate);
        this.add(empManager);
        this.add(submitAdd);

        this.add(deletePrompt);
        this.add(removeNumber);
        this.add(removeButton);



        submitSort.addActionListener(e -> {
            try {
                dataTemp = Main.sqlQueryFetchTable(String.format("SELECT * FROM EMPLOYEE ORDER BY %s ASC;", sortBy.getSelectedItem().toString()));
                assert dataTemp != null;
                columnNames = TableManipulate.getColumnName(dataTemp);
                data = TableManipulate.getTableData(dataTemp);
                this.remove(table);
                table = new createTablePanel(data,columnNames);

                this.add(table);
                this.add(employeeNum);
                this.add(fullName);
                this.add(empPosition);
                this.add(empPhone);
                this.add(empSalary);
                this.add(empAddress);
                this.add(empStartDate);
                this.add(assignedTruckPlate);
                this.add(empManager);
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
                PreparedStatement pstmt = Main.cnx.prepareStatement("INSERT INTO `employee` (employeeNum, fullName, empPosition, empPhone, empSalary, empAddress, empStartDate, assignedTruckPlate, empManager) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setInt(1, Integer.parseInt(employeeNum.getText()));
                pstmt.setString(2, fullName.getText());
                pstmt.setString(3, empPosition.getText());
                pstmt.setString(4, empPhone.getText());
                pstmt.setInt(5, Integer.parseInt(empSalary.getText()));
                pstmt.setString(6, empAddress.getText());
                pstmt.setDate(7, Date.valueOf(empStartDate.getText()));
                pstmt.setString(8, assignedTruckPlate.getText());
                if(empManager.getText().length() < 1){
                    pstmt.setNull(9, java.sql.Types.INTEGER);
                }else{
                    pstmt.setInt(9, Integer.parseInt(empManager.getText()));
                }
                pstmt.executeUpdate();

                this.add(table);
                this.add(employeeNum);
                this.add(fullName);
                this.add(empPosition);
                this.add(empPhone);
                this.add(empSalary);
                this.add(empAddress);
                this.add(empStartDate);
                this.add(assignedTruckPlate);
                this.add(empManager);
                this.add(submitAdd);

                this.add(deletePrompt);
                this.add(removeNumber);
                this.add(removeButton);
            }catch (SQLException ex){
            }
        });

        removeButton.addActionListener(e -> {
            try{
                PreparedStatement pstmt = Main.cnx.prepareStatement("DELETE FROM EMPLOYEE WHERE employeeNum = ?");
                pstmt.setInt(1, Integer.parseInt(removeNumber.getText()));
                pstmt.executeUpdate();

                this.add(table);
                this.add(employeeNum);
                this.add(fullName);
                this.add(empPosition);
                this.add(empPhone);
                this.add(empSalary);
                this.add(empAddress);
                this.add(empStartDate);
                this.add(assignedTruckPlate);
                this.add(empManager);
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
