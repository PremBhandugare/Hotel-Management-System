/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JTextField roomField, priceField;
    private JComboBox<String> availabilityBox, cleaningBox, bedTypeBox;
    private JButton addButton, backButton;

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }

    public AddRoom() {
        setBounds(450, 200, 1000, 450);
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(null);

        ImageIcon imgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image scaledImg = imgIcon.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        imageLabel.setBounds(400, 30, 500, 370);
        add(imageLabel);

        JLabel titleLabel = new JLabel("Add Rooms");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        titleLabel.setBounds(194, 10, 120, 22);
        mainPanel.add(titleLabel);

        JLabel roomLabel = new JLabel("Room Number");
        roomLabel.setForeground(new Color(25, 25, 112));
        roomLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomLabel.setBounds(64, 70, 102, 22);
        mainPanel.add(roomLabel);

        roomField = new JTextField();
        roomField.setBounds(174, 70, 156, 20);
        mainPanel.add(roomField);

        JLabel availabilityLabel = new JLabel("Availability");
        availabilityLabel.setForeground(new Color(25, 25, 112));
        availabilityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        availabilityLabel.setBounds(64, 110, 102, 22);
        mainPanel.add(availabilityLabel);

        availabilityBox = new JComboBox<>(new String[] { "Available", "Occupied" });
        availabilityBox.setBounds(176, 110, 154, 20);
        mainPanel.add(availabilityBox);

        JLabel cleaningLabel = new JLabel("Cleaning Status");
        cleaningLabel.setForeground(new Color(25, 25, 112));
        cleaningLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        cleaningLabel.setBounds(64, 150, 130, 22);
        mainPanel.add(cleaningLabel);

        cleaningBox = new JComboBox<>(new String[] { "Cleaned", "Dirty" });
        cleaningBox.setBounds(176, 150, 154, 20);
        mainPanel.add(cleaningBox);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setForeground(new Color(25, 25, 112));
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        priceLabel.setBounds(64, 190, 102, 22);
        mainPanel.add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(174, 190, 156, 20);
        mainPanel.add(priceField);

        JLabel bedTypeLabel = new JLabel("Bed Type");
        bedTypeLabel.setForeground(new Color(25, 25, 112));
        bedTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        bedTypeLabel.setBounds(64, 230, 102, 22);
        mainPanel.add(bedTypeLabel);

        bedTypeBox = new JComboBox<>(new String[] { "Single Bed", "Double Bed" });
        bedTypeBox.setBounds(176, 230, 154, 20);
        mainPanel.add(bedTypeBox);

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        addButton.setBounds(64, 321, 111, 33);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        mainPanel.add(addButton);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(198, 321, 111, 33);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        mainPanel.add(backButton);

        mainPanel.setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == addButton) {
                try {
                    conn db = new conn();
                    String roomNo = roomField.getText();
                    String availability = (String) availabilityBox.getSelectedItem();
                    String cleaningStatus = (String) cleaningBox.getSelectedItem();
                    String price = priceField.getText();
                    String bedType = (String) bedTypeBox.getSelectedItem();

                    String query = "INSERT INTO room VALUES ('" + roomNo + "', '" + availability + "', '" +
                                    cleaningStatus + "','" + price + "', '" + bedType + "')";
                    db.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Room Successfully Added");
                    this.setVisible(false);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            } else if (e.getSource() == backButton) {
                this.setVisible(false);
            }
        } catch (Exception ex) {
            // silently ignored
        }
    }
}

