package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_discharge extends JFrame {
    Patient_discharge(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(176,224,230));
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Times New Roman", Font.BOLD,20));
        label.setForeground(Color.BLACK);
        panel.add(label);

        JLabel label1 = new JLabel("Customer ID:");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("Times New Roman", Font.BOLD,16));
        label1.setForeground(Color.black);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
           conn c = new conn();
           ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
           while (resultSet.next()){
               choice.add(resultSet.getString("Number"));
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number:");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("Times New Roman", Font.BOLD,16));
        label2.setForeground(Color.black);
        panel.add(label2);

        JLabel RNo = new JLabel();
        RNo.setBounds(200,130,150,20);
        RNo.setFont(new Font("Times New Roman", Font.BOLD,16));
        RNo.setForeground(Color.black);
        panel.add(RNo);

        JLabel label3 = new JLabel("In Time:");
        label3.setBounds(30,180,150,20);
        label3.setFont(new Font("Times New Roman", Font.BOLD,16));
        label3.setForeground(Color.black);
        panel.add(label3);

        JLabel InTime = new JLabel();
        InTime.setBounds(200,180,250,20);
        InTime.setFont(new Font("Times New Roman", Font.BOLD,16));
        InTime.setForeground(Color.black);
        panel.add(InTime);

        JLabel label4 = new JLabel("Out Time:");
        label4.setBounds(30,230,150,20);
        label4.setFont(new Font("Times New Roman", Font.BOLD,16));
        label4.setForeground(Color.black);
        panel.add(label4);

        Date date = new Date();
        JLabel OutTime = new JLabel(""+date);
        OutTime.setBounds(200,230,250,20);
        OutTime.setFont(new Font("Times New Roman", Font.BOLD,16));
        OutTime.setForeground(Color.black);
        panel.add(OutTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(new Color(0,48,96));
        discharge.setForeground(Color.WHITE);
        discharge.setFocusable(false);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statement.executeUpdate("delete from patient_info where Number = '" + choice.getSelectedItem() + "'");
                    c.statement.executeUpdate("update room set availablity = 'Available' where room_no = '" + RNo.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        JButton Check = new JButton("Check");
        Check.setBounds(170,300,120,30);
        Check.setBackground(new Color(0,48,96));
        Check.setForeground(Color.WHITE);
        Check.setFocusable(false);
        panel.add(Check);
        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info where Number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        RNo.setText(resultSet.getString("Room_Number"));
                        InTime.setText(resultSet.getString("Time"));

                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(300,300,120,30);
        back.setBackground(new Color(0,48,96));
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Patient_discharge();
    }
}
