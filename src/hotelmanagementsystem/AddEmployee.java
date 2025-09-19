/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame {   // Third Frame

    // renamed text fields with meaningful names
    JTextField nameField;
    JTextField ageField;
    JTextField salaryField;
    JTextField phoneField;
    JTextField aadharField;
    JTextField emailField;
    JComboBox<String> jobComboBox;

    public AddEmployee() {
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778, 486);
        getContentPane().setLayout(null);

        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        nameLabel.setBounds(60, 30, 150, 27);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 30, 150, 27);
        add(nameField);

        JButton saveButton = new JButton("SAVE");
        saveButton.setBounds(200, 420, 150, 30);
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(Color.WHITE);
        add(saveButton);

        JLabel ageLabel = new JLabel("AGE");
        ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        ageLabel.setBounds(60, 80, 150, 27);
        add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(200, 80, 150, 27);
        add(ageField);

        JLabel genderLabel = new JLabel("GENDER");
        genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        genderLabel.setBounds(60, 120, 150, 27);
        add(genderLabel);

        JRadioButton maleRadio = new JRadioButton("MALE");
        maleRadio.setBackground(Color.WHITE);
        maleRadio.setBounds(200, 120, 70, 27);
        add(maleRadio);

        JRadioButton femaleRadio = new JRadioButton("FEMALE");
        femaleRadio.setBackground(Color.WHITE);
        femaleRadio.setBounds(280, 120, 70, 27);
        add(femaleRadio);

        JLabel jobLabel = new JLabel("JOB");
        jobLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        jobLabel.setBounds(60, 170, 150, 27);
        add(jobLabel);

        String jobs[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff",
                         "Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        jobComboBox = new JComboBox<>(jobs);
        jobComboBox.setBackground(Color.WHITE);
        jobComboBox.setBounds(200, 170, 150, 30);
        add(jobComboBox);

        JLabel salaryLabel = new JLabel("SALARY");
        salaryLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salaryLabel.setBounds(60, 220, 150, 27);
        add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setBounds(200, 220, 150, 27);
        add(salaryField);

        JLabel phoneLabel = new JLabel("PHONE");
        phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phoneLabel.setBounds(60, 270, 150, 27);
        add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(200, 270, 150, 27);
        add(phoneField);

        JLabel aadharLabel = new JLabel("AADHAR");
        aadharLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        aadharLabel.setBounds(60, 320, 150, 27);
        add(aadharLabel);

        aadharField = new JTextField();
        aadharField.setBounds(200, 320, 150, 27);
        add(aadharField);

        JLabel emailLabel = new JLabel("EMAIL");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        emailLabel.setBounds(60, 370, 150, 27);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 370, 150, 27);
        add(emailField);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 31));
        heading.setBounds(450, 24, 442, 35);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(
                "hotel/management/system/icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410, 80, 480, 410);
        add(image);

        // Action listener
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String name   = nameField.getText();
                String age    = ageField.getText();
                String salary = salaryField.getText();
                String phone  = phoneField.getText();
                String aadhar = aadharField.getText();
                String email  = emailField.getText();

                String gender = null;
                if (maleRadio.isSelected()) {
                    gender = "male";
                } else if (femaleRadio.isSelected()) {
                    gender = "female";
                }

                String job = (String) jobComboBox.getSelectedItem();

                try {
                    conn c = new conn();
                    String str = "INSERT INTO employee VALUES ('" + name + "', '" + age + "', '" +
                                 gender + "','" + job + "', '" + salary + "', '" + phone + "','" +
                                 aadhar + "', '" + email + "')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(900, 600);
        setVisible(true);
        setLocation(530, 200);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}