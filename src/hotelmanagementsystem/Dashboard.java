/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {
    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");
	
        setForeground(Color.CYAN);
        setLayout(null); 

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);
        
        JLabel HotelManagementSystem = new JLabel("THE BHANDUGARE'S WELCOMES YOU");
	HotelManagementSystem.setForeground(Color.WHITE);
        HotelManagementSystem.setFont(new Font("CenturySchoolBook", Font.PLAIN, 46));
	HotelManagementSystem.setBounds(400, 60, 1000, 85);
	NewLabel.add(HotelManagementSystem);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu HotelSystem = new JMenu("HOTEL MANAGEMENT");
        HotelSystem.setForeground(Color.BLUE);
	menuBar.add(HotelSystem);
		
        JMenuItem HotelDetails = new JMenuItem("RECEPTION");
	HotelSystem.add(HotelDetails);
		
	JMenu HotelAdmin = new JMenu("ADMIN");
        HotelAdmin.setForeground(Color.RED);
	menuBar.add(HotelAdmin);
        
        JMenuItem HotelDetail1 = new JMenuItem("ADD EMPLOYEE");
	HotelAdmin.add(HotelDetail1);
        
//        HotelDetail1.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                try{
//                    new AddEmployee().setVisible(true);
//                }catch(Exception e ){}
//            }
//	});
        

        JMenuItem HotelDetail2 = new JMenuItem("ADD ROOMS");
	HotelAdmin.add(HotelDetail2);
        
//        HotelDetail2.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                try{
//                    new AddRoom().setVisible(true);
//                }catch(Exception e ){}
//            }
//	});
        

//	HotelDetails.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                new Reception();
//            }
//	});
        
        
        JMenuItem HotelDetail3 = new JMenuItem("ADD DRIVERS");
	HotelAdmin.add(HotelDetail3);
        
//	HotelDetail3.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                try{
//                    new AddDrivers().setVisible(true);
//                }catch(Exception e ){}
//            }
//	});
        
		
        setSize(1950,1090);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
