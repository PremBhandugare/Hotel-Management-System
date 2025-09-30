/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddDrivers extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JTextField nameField, ageField, companyField, brandField, locationField;
    private JComboBox<String> genderBox, availabilityBox;
    private JButton addButton, backButton;
    private Choice sampleChoice; // not used but kept for structure

    public static void main(String[] args) {
        new AddDrivers().setVisible(true);
    }

    public AddDrivers() {
        setBounds(450, 200, 1000, 500);
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(null);

        ImageIcon imgIcon = new ImageIcon(
                ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image scaledImg = imgIcon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon finalIcon = new ImageIcon(scaledImg);
        JLabel imageLabel = new JLabel(finalIcon);
        imageLabel.setBounds(400, 30, 500, 370);
        add(imageLabel);

        JLabel headingLabel = new JLabel("Add Drivers");
        headingLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        headingLabel.setBounds(194, 10, 150, 22);
        mainPanel.add(headingLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setForeground(new Color(25, 25, 112));
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameLabel.setBounds(64, 70, 102, 22);
        mainPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(174, 70, 156, 20);
        mainPanel.add(nameField);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setForeground(new Color(25, 25, 112));
        ageLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        ageLabel.setBounds(64, 110, 102, 22);
        mainPanel.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(174, 110, 156, 20);
        mainPanel.add(ageField);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setForeground(new Color(25, 25, 112));
        genderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        genderLabel.setBounds(64, 150, 102, 22);
        mainPanel.add(genderLabel);

        genderBox = new JComboBox<>(new String[]{"Male", "Female"});
        genderBox.setBounds(176, 150, 154, 20);
        mainPanel.add(genderBox);

        JLabel companyLabel = new JLabel("Car Company");
        companyLabel.setForeground(new Color(25, 25, 112));
        companyLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        companyLabel.setBounds(64, 190, 102, 22);
        mainPanel.add(companyLabel);

        companyField = new JTextField();
        companyField.setBounds(174, 190, 156, 20);
        mainPanel.add(companyField);

        JLabel brandLabel = new JLabel("Car Brand");
        brandLabel.setForeground(new Color(25, 25, 112));
        brandLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        brandLabel.setBounds(64, 230, 102, 22);
        mainPanel.add(brandLabel);

        brandField = new JTextField();
        brandField.setBounds(174, 230, 156, 20);
        mainPanel.add(brandField);

        JLabel availabilityLabel = new JLabel("Available");
        availabilityLabel.setForeground(new Color(25, 25, 112));
        availabilityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        availabilityLabel.setBounds(64, 270, 102, 22);
        mainPanel.add(availabilityLabel);

        availabilityBox = new JComboBox<>(new String[]{"Yes", "No"});
        availabilityBox.setBounds(176, 270, 154, 20);
        mainPanel.add(availabilityBox);

        JLabel locationLabel = new JLabel("Location");
        locationLabel.setForeground(new Color(25, 25, 112));
        locationLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        locationLabel.setBounds(64, 310, 102, 22);
        mainPanel.add(locationLabel);

        locationField = new JTextField();
        locationField.setBounds(174, 310, 156, 20);
        mainPanel.add(locationField);

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        addButton.setBounds(64, 380, 111, 33);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        mainPanel.add(addButton);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(198, 380, 111, 33);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        mainPanel.add(backButton);

        mainPanel.setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent event) {
        try {
            if (event.getSource() == addButton) {
                try {
                    conn databaseConn = new conn();
                    String name = nameField.getText();
                    String age = ageField.getText();
                    String gender = (String) genderBox.getSelectedItem();
                    String company = companyField.getText();
                    String brand = brandField.getText();
                    String available = (String) availabilityBox.getSelectedItem();
                    String location = locationField.getText();

                    String sql = "INSERT INTO driver VALUES ('" + name + "', '" + age + "', '" + gender + "', '" +
                            company + "', '" + brand + "', '" + available + "', '" + location + "')";

                    databaseConn.s.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                    this.setVisible(false);
                } catch (Exception insertEx) {
                    System.out.println(insertEx);
                }
            } else if (event.getSource() == backButton) {
                this.setVisible(false);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

