package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class log extends JFrame {

    log() {


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,1960,1090);
        panel.setBackground(new Color(2,255,240));
        add(panel);

        JLabel nameLabel=new JLabel("_WELCOME_ To The Hospital Management System");
        nameLabel.setBounds(425,5,1200,150);
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD,48));
        nameLabel.setForeground(new Color(0, 48, 96));
        panel.add(nameLabel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/medi.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 800, 800);
        panel.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/drpic.png"));
        Image image1 = i11.getImage().getScaledInstance(225,225,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1= new JLabel(i22);
        label1.setBounds(540,105,500,500);
        panel.add(label1);

        JButton btn = new JButton("Login");
        btn.setBounds(695, 480, 195, 40);
        btn.setBackground(new Color(0, 48, 96));
        btn.setFocusable(false);
        btn.setFont(new Font("Open Sans", Font.BOLD, 20));
        btn.setForeground(Color.white);
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
            }
        });

        setSize(1960, 1090);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new log();
    }


}
