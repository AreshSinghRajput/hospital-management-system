package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    Ambulance(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(176,224,230));
        add(panel);

        JTable table =new JTable();
        table.setBounds(10,45,800,400);
        table.setBackground(new Color(176,224,230));
        table.setFont(new Font("Times New Roman", Font.BOLD,16));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(31,11,70,20);
        label1.setFont(new Font("Times New Roman", Font.BOLD,16));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setBounds(200,11,70,20);
        label2.setFont(new Font("Times New Roman", Font.BOLD,16));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        JLabel label3 = new JLabel("Car Name");
        label3.setBounds(366,11,150,20);
        label3.setFont(new Font("Times New Roman", Font.BOLD,16));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JLabel label4 = new JLabel("Available");
        label4.setBounds(520,9,70,20);
        label4.setFont(new Font("Times New Roman", Font.BOLD,16));
        label4.setForeground(Color.BLACK);
        panel.add(label4);

        JLabel label5 = new JLabel("Location");
        label5.setBounds(700,11,70,20);
        label5.setFont(new Font("Times New Roman", Font.BOLD,16));
        label5.setForeground(Color.BLACK);
        panel.add(label5);



        JButton back = new JButton("Back");
        back.setBounds(380,490,120,30);
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
        setSize(900,550);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ambulance();
    }
}
