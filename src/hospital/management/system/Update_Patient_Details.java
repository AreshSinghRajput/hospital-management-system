package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Patient_Details extends JFrame {
    Update_Patient_Details() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(176,224,230));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124, 11, 260, 25);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label1.setForeground(Color.black);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25, 88, 100, 15);
        label2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        label2.setForeground(Color.black);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 85, 140, 25);
        panel.add(choice);

        try{
           conn c = new conn();
           ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
           while (resultSet.next()){
               choice.add(resultSet.getString("Name"));
           }

        }
           catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25, 129, 130, 15);
        label3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        label3.setForeground(Color.black);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,140,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25, 174, 100, 15);
        label4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        label4.setForeground(Color.black);
        panel.add(label4);

        JTextField textFieldInTime = new JTextField();
        textFieldInTime.setBounds(248,174,140,20);
        panel.add(textFieldInTime);

        JLabel label5 = new JLabel("Amount Paid (Rs) :");
        label5.setBounds(25, 216, 130, 15);
        label5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        label5.setForeground(Color.black);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount (Rs) :");
        label6.setBounds(25, 261, 150, 15);
        label6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        label6.setForeground(Color.black);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setForeground(Color.WHITE);
        check.setBackground(new Color(0,48,96));
        check.setFocusable(false);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String id = choice.getSelectedItem();
               String q = "select * from patient_info where Name = '"+id+"'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldInTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));
                    }
                    ResultSet resultSet1 = c.statement.executeQuery("select * from Room where room_no = '"+textFieldR.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(56,378,89,23);
        update.setForeground(Color.WHITE);
        update.setBackground(new Color(0,48,96));
        update.setFocusable(false);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   conn c = new conn();
                   String q = choice.getSelectedItem();
                   String room = textFieldR.getText();
                   String time = textFieldInTime.getText();
                   String amount = textFieldAmount.getText();
                   c.statement.executeUpdate("update patient_info set Room_Number = '"+room+"',Time = '"+time+"', Deposite ='"+amount+"' where Name ='"+q+"'");
                   JOptionPane.showMessageDialog(null,"Update Successfully");
                   setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });


        JButton back = new JButton("BACK");
        back.setBounds(168,378 ,89,23);
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
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Update_Patient_Details();
    }
}
