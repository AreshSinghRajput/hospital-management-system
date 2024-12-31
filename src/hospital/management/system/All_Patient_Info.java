package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_Patient_Info extends JFrame {
    All_Patient_Info(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(176,224,230));
        add(panel);

        JTable table =new JTable();
        table.setBounds(10,50,900,450);
        table.setBackground(new Color(176,224,230));
        table.setFont(new Font("Times New Roman", Font.BOLD,16));
        panel.add(table);

        try{
            conn c = new conn();
            String q = "select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("ID");
        label1.setBounds(31,11,70,20);
        label1.setFont(new Font("Times New Roman", Font.BOLD,18));
        label1.setForeground(Color.black);
        panel.add(label1);

        JLabel label2 = new JLabel("Number");
        label2.setBounds(150,11,70,20);
        label2.setFont(new Font("Times New Roman", Font.BOLD,18));
        label2.setForeground(Color.black);
        panel.add(label2);

        JLabel label3 = new JLabel("Name");
        label3.setBounds(270,11,150,20);
        label3.setFont(new Font("Times New Roman", Font.BOLD,18));
        label3.setForeground(Color.black);
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(360,9,70,20);
        label4.setFont(new Font("Times New Roman", Font.BOLD,18));
        label4.setForeground(Color.black);
        panel.add(label4);

        JLabel label5 = new JLabel("Disease");
        label5.setBounds(480,11,70,20);
        label5.setFont(new Font("Times New Roman", Font.BOLD,18));
        label5.setForeground(Color.black);
        panel.add(label5);

        JLabel label6 = new JLabel("Room");
        label6.setBounds(600,11,70,20);
        label6.setFont(new Font("Times New Roman", Font.BOLD,18));
        label6.setForeground(Color.black);
        panel.add(label6);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(700,11,150,20);
        label7.setFont(new Font("Times New Roman", Font.BOLD,18));
        label7.setForeground(Color.black);
        panel.add(label7);

        JLabel label8 = new JLabel("Deposite");
        label8.setBounds(805,9,70,20);
        label8.setFont(new Font("Times New Roman", Font.BOLD,18));
        label8.setForeground(Color.black);
        panel.add(label8);

        JButton back = new JButton("Back");
        back.setBounds(370,510,120,30);
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
        setSize(900,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new All_Patient_Info();
    }
}
