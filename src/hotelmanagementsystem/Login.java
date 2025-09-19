package hotelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel userLbl, passLbl;
    JTextField userTxt;
    JPasswordField passTxt;
    JButton loginBtn, cancelBtn;

    Login() {
        super("Login");
        setLayout(null);

        userLbl = new JLabel("Username");
        userLbl.setBounds(40,20,100,30);
        add(userLbl);

        passLbl = new JLabel("Password");
        passLbl.setBounds(40,70,100,30);
        add(passLbl);

        userTxt = new JTextField();
        userTxt.setBounds(150,20,150,30);
        add(userTxt);

        passTxt = new JPasswordField();
        passTxt.setBounds(150,70,150,30);
        add(passTxt);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image scaled = img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        JLabel picLbl = new JLabel(new ImageIcon(scaled));
        picLbl.setBounds(350,10,150,150);
        add(picLbl);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(40,140,120,30);
        loginBtn.setFont(new Font("serif",Font.BOLD,15));
        loginBtn.addActionListener(this);
        add(loginBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(180,140,120,30);
        cancelBtn.setFont(new Font("serif",Font.BOLD,15));
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        getContentPane().setBackground(Color.WHITE);
        setSize(600,300);
        setLocation(600,350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==loginBtn){
            try{
                conn db = new conn();
                String user = userTxt.getText();
                String pass = new String(passTxt.getPassword());
                String q = "select * from login where username='"+user+"' and password='"+pass+"'";
                ResultSet rs = db.s.executeQuery(q);
                if(rs.next()){
                    new Dashboard().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } else if(e.getSource()==cancelBtn){
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Login();
    }
}
