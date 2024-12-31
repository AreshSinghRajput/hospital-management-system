package hospital.management.system;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Reception extends JFrame {
    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,670);
        panel.setBackground(new Color(240,255,240));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(176,224,230));
        add(panel1);

        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icon/docter.jpg"));
        Image image2 = i111.getImage().getScaledInstance(1525,670,Image.SCALE_DEFAULT);
        ImageIcon i222 = new ImageIcon(image2);
        JLabel label6 = new JLabel(i222);
        label6.setBounds(5,5,1515,615);
        panel.add(label6);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
        Image image = i1.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1350,0,150,150);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/medical.png"));
        Image image1 = i11.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1= new JLabel(i22);
        label1.setBounds(15,0,150,150);
        panel1.add(label1);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(200,30,180,35);
        btn1.setBackground(new Color(0,48,96));
        btn1.setFocusable(false);
        btn1.setFont(new Font("Open Sans", Font.BOLD,14));
        btn1.setForeground(Color.white);
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new NEW_PATIENT();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(200,80,180,35);
        btn2.setBackground(new Color(0,48,96));
        btn2.setFocusable(false);
        btn2.setFont(new Font("Open Sans", Font.BOLD,14));
        btn2.setForeground(Color.WHITE);
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(430,30,180,35);
        btn3.setFocusable(false);
        btn3.setBackground(new Color(0,48,96));
        btn3.setFont(new Font("Open Sans", Font.BOLD,14));
        btn3.setForeground(Color.WHITE);
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(430,80,180,35);
        btn4.setBackground(new Color(0,48,96));
        btn4.setFocusable(false);
        btn4.setFont(new Font("Open Sans", Font.BOLD,14));
        btn4.setForeground(Color.WHITE);
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });

        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(650,30,180,35);
        btn5.setFocusable(false);
        btn5.setBackground(new Color(0,48,96));
        btn5.setFont(new Font("Open Sans", Font.BOLD,14));
        btn5.setForeground(Color.WHITE);
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new All_Patient_Info();
            }
        });

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(650,80,180,35);
        btn6.setBackground(new Color(0,48,96));
        btn6.setFocusable(false);
        btn6.setFont(new Font("Open Sans", Font.BOLD,14));
        btn6.setForeground(Color.WHITE);
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new Patient_discharge();
            }
        });

        JButton btn7 = new JButton("Update patient Detail");
        btn7.setBounds(875,30,180,35);
        btn7.setBackground(new Color(0,48,96));
        btn7.setFocusable(false);
        btn7.setFont(new Font("Open Sans", Font.BOLD,14));
        btn7.setForeground(Color.WHITE);
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Update_Patient_Details();
            }
        });

        JButton btn8 = new JButton("Hospital Ambulance");
        btn8.setBounds(875,80,180,35);
        btn8.setBackground(new Color(0,48,96));
        btn8.setFocusable(false);
        btn8.setFont(new Font("Open Sans", Font.BOLD,14));
        btn8.setForeground(Color.WHITE);
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Ambulance();
            }
        });

        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(1100,30,180,35);
        btn9.setBackground(new Color(0,48,96));
        btn9.setFocusable(false);
        btn9.setFont(new Font("Open Sans", Font.BOLD,14));
        btn9.setForeground(Color.WHITE);
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new SearchRoom();
            }
        });

        JButton btn10 = new JButton("Logout");
        btn10.setBounds(1100,80,180,35);
        btn10.setBackground(Color.blue);
        btn10.setFocusable(false);
        btn10.setFont(new Font("Open Sans", Font.BOLD,14));
        btn10.setForeground(Color.WHITE);
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              setVisible(false);
              new login();
           }
       });
        
        setSize(1960,1090);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }
}
