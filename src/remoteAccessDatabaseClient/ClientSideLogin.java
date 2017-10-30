package remoteAccessDatabaseClient;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;

public class ClientSideLogin extends JFrame{

	ClientSideLogin(){
		//Set Size of JFrame
		setSize(553, 385);
		//Make it so you cannot resize JFrame
		setResizable(false);
		
		//Adds A container To Store Components
		Container c = new Container();
		//Set Layout to Null to move Components more Freely 
		c.setLayout(null);
		//Add Container to JFrame
		getContentPane().add(c);
		
		//Implement a new label to welcome clients
		JLabel intro = new JLabel("Welcome!");
		//Sets Font and size of text
		intro.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		//Set Alignment
		intro.setHorizontalAlignment(SwingConstants.CENTER);
		//Set Location on the gui
		intro.setLocation(204, 0);
		//Set Label Size
		intro.setSize(93, 21);
		//Set to visible
		intro.setVisible(true);
		//Add to container c
		c.add(intro);
		
		//Implements new label for username
		JLabel usernameLabel = new JLabel("Name");
		usernameLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//Set Size of the usernameword field
		usernameLabel.setSize(187,23);
		//Set Size of the usernameword field
		usernameLabel.setLocation(160,122);
		//Set the usernameword filed to visible
		usernameLabel.setVisible(true);
		//Add usernamewordField to container c
		c.add(usernameLabel);
		
		//Implements a JLabel for company name error
		JLabel errorName = new JLabel("Error Name Is Not Registered");
		errorName.setForeground(Color.RED);
		errorName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		errorName.setHorizontalAlignment(SwingConstants.CENTER);
		//Set Location
		errorName.setLocation(160,181);
		//Set Size
		errorName.setSize(187, 30);
		//
		errorName.setVisible(true);
		//Create and set a border that is the same color as the frame
		Border background = BorderFactory.createLineBorder(getBackground(), 1);
		errorName.setBorder(background);
		//Add error company name to container c
		c.add(errorName);
		
		//Create A username Field named username
		JTextField username = new JTextField("");
		username.setHorizontalAlignment(SwingConstants.CENTER);
		//Set Size of the usernameword field
		username.setSize(187,30);
		//Set Size of the usernameword field
		username.setLocation(160,146);
		//Set the usernameword filed to visible
		username.setVisible(true);
		//Add usernamewordField to container c
		c.add(username);
		
		
		//Implements a JLabel for company name error
		JLabel errorCN = new JLabel("Error Company Name Was Not Found");
		errorCN.setForeground(Color.RED);
		errorCN.setHorizontalAlignment(SwingConstants.CENTER);
		errorCN.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		//Set Location
		errorCN.setLocation(148,92);
		//Set Size
		errorCN.setSize(212, 30);
		//
		errorCN.setVisible(true);
		//Set a border that is the same color as the frame
		errorCN.setBorder(background);
		//Add error company name to container c
		c.add(errorCN);
		
		
		//Implements new label for Company Name
		JLabel companyLabel = new JLabel("Enter Company Name");
		//Set Font details
		companyLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		//Makes text aligned in JLabel
		companyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//Set Size of the Company Name field
		companyLabel.setSize(187,23);
		//Set Size of the Company Name field
		companyLabel.setLocation(160,37);
		//Set the Company Name filed to visible
		companyLabel.setVisible(true);
		//Add Company Name Field to container c
		c.add(companyLabel);
		
		
		//Create A Company Name Field named Company Name
		JTextField companyName = new JTextField("");
		companyName.setHorizontalAlignment(SwingConstants.CENTER);
		//Set Size of the Company Name field
		companyName.setSize(187,30);
		//Set Size of the Company Name field
		companyName.setLocation(160,59);
		//Set the Company Name filed to visible
		companyName.setVisible(true);
		//Add Company Name to container c
		c.add(companyName);
		
		
		//Implements a JLabel for company name error
		JLabel errorPort = new JLabel("Error Port Not Found");
		errorPort.setForeground(Color.RED);
		errorPort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		errorPort.setHorizontalAlignment(SwingConstants.CENTER);
		//Set Location
		errorPort.setLocation(160,263);
		//Set Size
		errorPort.setSize(187, 30);
		//
		errorPort.setVisible(true);
		//Set a border that is the same color as the frame
		errorPort.setBorder(background);
		//Add error company name to container c
		c.add(errorPort);
		
		//Implements new label for Server Port
		JLabel portLabel = new JLabel("Enter Server Port");
		portLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		portLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//Set Size of the Company Server Port
		portLabel.setSize(187,23);
		//Set Size of the Server Port field
		portLabel.setLocation(160,212);
		//Set the Server Port filed to visible
		portLabel.setVisible(true);
		//Add Server Port Field to container c
		c.add(portLabel);
				
		//Create A Port Field named Port
		JTextField port = new JTextField("");
		port.setHorizontalAlignment(SwingConstants.CENTER);
		//Set Size of the Port field
		port.setSize(187,30);
		//Set Size of the Port field
		port.setLocation(160,235);
		//Set the Port filed to visible
		port.setVisible(true);
		//Add Port to container c
		c.add(port);
		
		
		
		//Iniate login button
		JButton login = new JButton("Login");
		//Set Size
		login.setSize(99,31);
		//Set Location
		login.setLocation(204,304);
		//Add to container c
		c.add(login);
		//Set Visible
		login.setVisible(true);
		//Adds button action listener to tell button what to do when clicked
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Height: " + getHeight() + "  Width: " + getWidth());
				
			}
			
		});
		
		//Set JFrame to Visible
		setVisible(true);
		
	}
}
