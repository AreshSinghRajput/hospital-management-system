package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(176,224,230));
        add(panel);

        JTable table =new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(176,224,230));
        table.setFont(new Font("Times New Roman", Font.BOLD,18));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from department";
            ResultSet resultSet = c . statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Department");
        label1.setBounds(145,11,105,20);
        label1.setFont(new Font("Times New Roman", Font.BOLD,18));
        label1.setForeground(Color.black);
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(431,11,150,20);
        label2.setFont(new Font("Times New Roman", Font.BOLD,18));
        label2.setForeground(Color.black);
        panel.add(label2);

        JButton b1 = new JButton("Back");
        b1.setBounds(260,410,130,35);
        b1.setBackground(new Color(0,48,96));
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}

