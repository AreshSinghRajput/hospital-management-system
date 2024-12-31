package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;

    SearchRoom(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(176,224,230));
        add(panel);

        JLabel forRoom = new JLabel("Search For Room");
        forRoom.setBounds(250,11,186,31);
        forRoom.setForeground(Color.black);
        forRoom.setFont(new Font("Times New Roman", Font.BOLD,24));
        panel.add(forRoom);

        JLabel status = new JLabel("Status : ");
        status.setBounds(70,70,80,20);
        status.setForeground(Color.black);
        status.setFont(new Font("Times New Roman", Font.BOLD,18));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,30);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBackground(new Color(176,224,230));
        table.setBounds(0,150,700,220);
        table.setForeground(Color.black);
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(23,120,150,20);
        Roomno.setForeground(Color.black);
        Roomno.setFont(new Font("Times New Roman", Font.BOLD,16));
        panel.add(Roomno);

        JLabel available = new JLabel("Availability");
        available.setBounds(190,120,150,20);
        available.setForeground(Color.black);
        available.setFont(new Font("Times New Roman", Font.BOLD,16));
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(400,120,150,20);
        price.setForeground(Color.black);
        price.setFont(new Font("Times New Roman", Font.BOLD,16));
        panel.add(price);

        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(540,120,150,20);
        Bed.setForeground(Color.black);
        Bed.setFont(new Font("Times New Roman", Font.BOLD,16));
        panel.add(Bed);

        JButton Search = new JButton("Search");
        Search.setBounds(200,420,120,25);
        Search.setForeground(Color.WHITE);
        Search.setBackground(new Color(0,48,96));
        Search.setFont(new Font("Times New Roman", Font.BOLD,16));
        Search.setFocusable(false);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from Room where availablity = '"+choice.getSelectedItem()+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        JButton Back = new JButton("Back");
        Back.setBounds(350,420,120,25);
        Back.setForeground(Color.WHITE);
        Back.setBackground(new Color(0,48,96));
        Back.setFocusable(false);
        Back.setFont(new Font("Times New Roman", Font.BOLD,16));
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
