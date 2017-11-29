package remoteAccessDatabaseClient;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ClientSide{
	
	//Client Login
	private static JFrame clientLogin;
	private static JFrame clientFrame;
	
	private static JLabel intro;
	private static JLabel usernameLabel;
	private static JLabel errorName;
	private static JLabel errorCN;
	private static JLabel companyLabel;
	private static JLabel errorPort;
	private static JLabel portLabel;
	private static JTextField username;
	private static JTextField port;
	private static JTextField companyName;
	private static JButton login;
	
	//Client Screen
	private static JButton logout;
	private static JComboBox optionA;
	private static JComboBox optionB;
	private static JComboBox optionC;
	private static JComboBox optionD;
	private static JPanel table;
	//Border
	private static Border black = BorderFactory.createLineBorder(Color.BLACK, 1);
	private static ImageIcon frameIcon = new ImageIcon("src\\remoteAccessDatabaseClient\\ClientIcon.png");
	
	/**
	 * 
	 */
	public void ClientSideLogin(){
		//JFrame clientLogin
		clientLogin = new JFrame("Login");
		clientLogin.setSize(553, 385);
		clientLogin.setResizable(false);
		clientLogin.setDefaultCloseOperation(2); //2=EXIT_ON_CLOSE
		clientLogin.setIconImage(frameIcon.getImage());
		
		
		//Container c
		Container c = new Container();
		c.setLayout(null);
		clientLogin.getContentPane().add(c);
		
		//JLabel intro
		intro = new JLabel("Welcome!");
		intro.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		intro.setHorizontalAlignment(SwingConstants.CENTER);
		intro.setLocation(204, 0);
		intro.setSize(93, 21);
		intro.setVisible(true);
		c.add(intro);
		
		//Implements usernameLabel
		usernameLabel = new JLabel("Name");
		usernameLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setSize(187,23);
		usernameLabel.setLocation(160,122);
		usernameLabel.setVisible(true);
		c.add(usernameLabel);
		
		//JLabel erroName
		errorName = new JLabel("Error Name Is Not Registered");
		errorName.setForeground(Color.RED);
		errorName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		errorName.setHorizontalAlignment(SwingConstants.CENTER);
		errorName.setLocation(160,181);
		errorName.setSize(187, 30);
		errorName.setVisible(false);
		Border background = BorderFactory.createLineBorder(clientLogin.getBackground(), 1);
		errorName.setBorder(background);
		c.add(errorName);
		
		//JTextField username
		username = new JTextField("");
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setSize(187,30);
		username.setLocation(160,146);
		username.setVisible(true);
		c.add(username);
		
		
		//JLabel errorCN
		errorCN = new JLabel("Error Company Name Was Not Found");
		errorCN.setForeground(Color.RED);
		errorCN.setHorizontalAlignment(SwingConstants.CENTER);
		errorCN.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		errorCN.setLocation(148,92);
		errorCN.setSize(212, 30);
		errorCN.setVisible(false);
		errorCN.setBorder(background);
		c.add(errorCN);
		
		
		//JLabel companyLabel
		companyLabel = new JLabel("Enter Company Name");
		companyLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		companyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		companyLabel.setSize(187,23);
		companyLabel.setLocation(160,37);
		companyLabel.setVisible(true);
		c.add(companyLabel);
		
		
		//JTextField companyName
		companyName = new JTextField("");
		companyName.setHorizontalAlignment(SwingConstants.CENTER);
		companyName.setSize(187,30);
		companyName.setLocation(160,59);
		companyName.setVisible(true);
		c.add(companyName);
		
		
		//JLabel errorPort
		errorPort = new JLabel("Error Port Not Found");
		errorPort.setForeground(Color.RED);
		errorPort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		errorPort.setHorizontalAlignment(SwingConstants.CENTER);
		errorPort.setLocation(160,263);
		errorPort.setSize(187, 30);
		errorPort.setVisible(false);
		errorPort.setBorder(background);
		c.add(errorPort);
		
		//JLabel portLabel
		portLabel = new JLabel("Enter Server Port");
		portLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		portLabel.setHorizontalAlignment(SwingConstants.CENTER);
		portLabel.setSize(187,23);
		portLabel.setLocation(160,212);
		portLabel.setVisible(true);
		c.add(portLabel);
				
		//JTextField port
		port = new JTextField("");
		port.setHorizontalAlignment(SwingConstants.CENTER);
		port.setSize(187,30);
		port.setLocation(160,235);
		port.setVisible(true);
		c.add(port);
		
		
		
		//Initiate login button
		login = new JButton("Login");
		login.setSize(99,31);
		login.setLocation(204,304);
		c.add(login);
		login.setVisible(true);
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Height: " + clientLogin.getHeight() + "  Width: " + clientLogin.getWidth());
			if(port.getText().equals("") || companyName.getText().equals("") || username.getText().equals("")) {
				if(port.getText().equals("")) {
					errorPort.setVisible(true);
				}else {
					errorPort.setVisible(false);
				}
				if(companyName.getText().equals("")) {
					errorCN.setVisible(true);
				}else {
					errorCN.setVisible(false);
				}
				if(username.getText().equals("")) {
					errorName.setVisible(true);
				}else {
					errorName.setVisible(false);
				}
			}else {
				clientScreen();
				clientLogin.dispose();
			}
				
			}
			
		});
		
		//Set JFrame to Visible
		clientLogin.setVisible(true);
		
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void clientScreen() {
		//JFrame clintFrame
		clientFrame = new JFrame("Client Window");
		clientFrame.setSize(1382, 784);
		clientFrame.setVisible(true);
		clientFrame.setDefaultCloseOperation(2); //2=EXIT_ON_CLOSE
		clientFrame.setIconImage(frameIcon.getImage());
		
		//Container clientCon
		Container clientCon = new Container();
		clientCon.setLayout(null);
		clientFrame.getContentPane().add(clientCon);
		
		//JButton logout
		logout = new JButton("Logout");
		logout.setSize(92,32);
		logout.setLocation(1260,354);
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ClientSideLogin();	
				clientFrame.dispose();
			}
			
		});
		
		optionA = new JComboBox();
		optionA.setSize(190,37);
		optionA.setLocation(40,196);
		
		
		optionB = new JComboBox();
		optionB.setSize(190,37);
		optionB.setLocation(280,196);
		
		
		optionC = new JComboBox();
		optionC.setSize(190,37);
		optionC.setLocation(520,196);
		
		
		optionD = new JComboBox();
		optionD.setSize(190,37);
		optionD.setLocation(760,196);
		
		
		table = new JPanel();
		table.setSize(1362, 349);
		table.setLocation(1, 392);
		table.setBorder(black);
		
		clientFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		clientCon.add(logout);
		clientCon.add(optionA);
		clientCon.add(optionB);
		clientCon.add(optionC);
		clientCon.add(optionD);
		clientCon.add(table);
		
	}
}
