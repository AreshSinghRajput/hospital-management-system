package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1,b2;

    login(){

        super("Login page");

        // Username Label
        JLabel nameLabel=new JLabel("Username:");
        nameLabel.setBounds(65,40,200,150);
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD,24));
        nameLabel.setForeground(Color.white);
        add(nameLabel);

        // Password Label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(69, 80, 200, 150);
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        passwordLabel.setForeground(Color.white);
        add(passwordLabel);

        // Username TextField
        textField = new JTextField();
        textField.setBounds(180, 100, 200, 30);
        textField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(textField);

        // Password Field
        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(180, 140, 200, 30);
        jPasswordField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(jPasswordField);


        // Image Icon
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/log.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(300, 0, 550, 370);
        add(label);

        // Login Button
        b1 = new JButton("Login");
        b1.setFocusable(false);
        b1.setBounds(100, 200, 120, 40);
        b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        add(b1);

        // Cancel Button
        b2 = new JButton("Cancel");
        b2.setFocusable(false);
        b2.setBounds(250, 200, 120, 40);
        b2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        b2.addActionListener(this);
        add(b2);

        // Frame Properties
        getContentPane().setBackground(new Color(0,48,96));
        setSize(800,400);
        setLocation(370,230);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1){
            try{
                conn c = new conn();
                String user = textField.getText();
                String Pass = jPasswordField.getText();

                String Q = "select * from login where ID = '"+user+"' and PW = '"+Pass+"' ";
                ResultSet resultSet =  c.statement.executeQuery(Q);

                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            System.exit(10);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}

