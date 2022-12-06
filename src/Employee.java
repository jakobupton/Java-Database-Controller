import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Employee extends JPanel{
    String[] columnNames = {"employeeNum", "fullName", "empPosition", "empPhone", "empSalary", "empAddress", "empStartDate", "assignedTruckPlate", "empManager"};
    Object[][] data = {
            {5001, "Tyler Olsen(FIRST)", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", new Date(), "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001},
            {5001, "Tyler Olsen", "Supervisor", "604-424-4664", 55000, "60 Randell Mill Ave", "2017-03-08", "MVR289", "-"},
            {5002, "Michael Aldor(LAST)", "Driver", "604-439-2944", 45000, "8319 Hall Road", "2020-01-01", "9AFK3L3", 5001}
    };

    public Employee(){

        super(true);

        this.add(new createTablePanel(data, columnNames));

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        Window.drawCenteredString(g, "Testing7", this.getWidth()/2, 50, Window.f30);
    }
}
