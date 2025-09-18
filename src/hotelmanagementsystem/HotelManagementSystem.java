package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JLabel backgroundLabel;
    JButton nextButton;
    
    public HotelManagementSystem() {
        setSize(1366,430);    // Window size
        setLayout(null);      // No layout manager, manual positioning
        setLocation(300,300); // Window position on screen

        // Button
        nextButton = new JButton("Next");
        nextButton.setBackground(Color.WHITE);
        nextButton.setForeground(Color.BLACK);

        // Background image
        ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(1366, 390, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        backgroundLabel = new JLabel(scaledIcon);

        // Title label
        JLabel titleLabel = new JLabel("HOTEL MANAGEMENT SYSTEM");
        titleLabel.setBounds(30, 300, 1500, 100);
        titleLabel.setFont(new Font("serif", Font.PLAIN, 70));
        titleLabel.setForeground(Color.RED);
        backgroundLabel.add(titleLabel);

        // Positioning
        nextButton.setBounds(1170, 325, 150, 50);
        backgroundLabel.setBounds(0, 0, 1366, 390);

        // Adding components
        backgroundLabel.add(nextButton);
        add(backgroundLabel);

        // Add button click listener
        nextButton.addActionListener(this);
        setVisible(true);

        // Blinking title effect
        while(true){
            titleLabel.setVisible(false);
            try { Thread.sleep(500); } catch(Exception e){}
            titleLabel.setVisible(true);
            try { Thread.sleep(500); } catch(Exception e){}
        }
    }
    
    // When "Next" button is clicked
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
        HotelManagementSystem window = new HotelManagementSystem();
        window.setVisible(true);
    }
}
