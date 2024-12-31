package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Stack;

public class NEW_PATIENT extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNumber, textName , textFieldDisease, textFieldDeposite;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton b1,b2;


    NEW_PATIENT(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(176,224,230));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image image = imageIcon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(450,10,400,400);
        panel.add(label);

        JLabel labelName = new JLabel("_NEW PATIENT FORM_");
        labelName.setBounds(118,11,320,53);
        labelName.setFont(new Font("Times New Roman", Font.BOLD,28));
        panel.add(labelName);


        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Times New Roman", Font.BOLD,18));
        labelID.setForeground(Color.black);
        panel.add(labelID);

        comboBox = new JComboBox(new String[] {"Aadhar Card","Voter Id","Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(0,48,96));
        comboBox.setFont(new Font("Times New Roman", Font.BOLD,18));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);

        JLabel labelNumber = new JLabel(" ID Number :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Times New Roman", Font.BOLD,18));
        labelNumber.setForeground(Color.black);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(35,151,200,14);
        labelName1.setFont(new Font("Times New Roman", Font.BOLD,18));
        labelName1.setForeground(Color.black);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Times New Roman", Font.BOLD,18));
        labelGender.setForeground(Color.black);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Times New Roman", Font.BOLD,16));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(271,191,80,20);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Times New Roman", Font.BOLD,16));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(350,191,80,20);
        panel.add(r2);

        ButtonGroup group =new ButtonGroup();
        group.add(r1);
        group.add(r2);


        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35,231,200,14);
        labelDisease.setFont(new Font("Times New Roman", Font.BOLD,18));
        labelDisease.setForeground(Color.black);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Times New Roman", Font.BOLD,18));
        labelRoom.setForeground(Color.black);
        panel.add(labelRoom);


        c1 = new Choice();
        try{
           conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Times New Roman", Font.BOLD,18));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(0,48,96));
        panel.add(c1);


        JLabel labelDate = new JLabel("Time :");
        labelDate.setBounds(35,316,200,14);
        labelDate.setFont(new Font("Times New Roman", Font.BOLD,18));
        labelDate.setForeground(Color.black);
        panel.add(labelDate);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,300,14);
        date.setForeground(Color.black);
        date.setFont(new Font("Times New Roman", Font.BOLD,18));
        panel.add(date);

        JLabel labelDeposite = new JLabel("Deposite :");
        labelDeposite.setBounds(35,359,200,17);
        labelDeposite.setFont(new Font("Times New Roman", Font.BOLD,18));
        labelDeposite.setForeground(Color.black);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271,359,150,20);
        panel.add(textFieldDeposite);

        b1 = new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setFont(new Font("Times New Roman", Font.BOLD,18));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(0,48,96));
        b1.setFocusable(false);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260,430,120,30);
        b2.setFont(new Font("Times New Roman", Font.BOLD,18));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(0,48,96));
        b2.setFocusable(false);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1){

            conn c = new conn();
            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN = "Male";
            }else if(r2.isSelected()){
                radioBTN = "Female";
            }

            String s1 = (String)comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();

            try{
                String Q = "insert into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String Q1 = "update Room set availablity = 'occupied' where room_no = "+s6;
                c.statement.executeUpdate(Q);
                c.statement.executeUpdate(Q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }
            catch (Exception E) {
               E.printStackTrace();
            }

        }else {
            setVisible(false);
        }

    }

        public static void main (String[]args){
            new NEW_PATIENT();
        }


    }
