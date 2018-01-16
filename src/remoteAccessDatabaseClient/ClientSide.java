package remoteAccessDatabaseClient;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("rawtypes")

public class ClientSide{
	
	private static String[][][] localInfo;
	private static NetworkClient blackMagic;
	
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
	private static JTable table;
	private static DefaultTableModel tableModel;
	private static JScrollPane tableContainer;
	private static String columnNames[];
	private static String columnContents[][];
	
	private static JTable table2;
	private static JScrollPane tableContainer2;
	private static String columnNames2[];
	private static String columnContents2[][];
	
	//private static JPanel table;
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
		clientLogin.setDefaultCloseOperation(3); //3=EXIT_ON_CLOSE
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
		
		//JTextField userName
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
			
			public void actionPerformed(ActionEvent e) {
				//blackMagic=new NetworkClient()
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
		clientFrame.setDefaultCloseOperation(0); //3=EXIT_ON_CLOSE
		
		clientFrame.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent event) {
	        	System.out.println("Safe Shutdown Starting....");
	        	//Close the network stuff here
	        	System.exit(0);
	        }
		});
		
		clientFrame.setIconImage(frameIcon.getImage());
		
		//Container clientCon
		Container clientCon = new Container();
		clientCon.setLayout(null);
		clientFrame.getContentPane().add(clientCon);
		
		//JButton logout
		logout = new JButton("Logout");
		logout.setSize(92,32);
		logout.setLocation(1230,349);
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
		
		
		columnNames = new String[] {
				"Test","Test2","Test3","Test4"
		};
		
		columnContents = new String[][] {
				{"TestA","TestA2","TestA3","TestA4"},
				{"TestB","TestB2","TestB3","TestA4"},
				{"TestC","TestC2","TestC3","TestA4"}
		};
		
		
		tableModel=new DefaultTableModel();
		table=new JTable(tableModel);
		table.setSize(1362, 349);
		table.setLocation(1, 392);
		table.setBorder(black);
		
		//these two will create blank columns and then fill them
		addTableColumns(4);
		addTableRows(3, columnContents);
		changeColumnHeadings(columnNames);
		
		table.setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel=table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		cellSelectionModel.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
		        String selectedData = null;
		        
		        //selectedData=(String) table.get

		        
		        
		        int[] selectedRow = table.getSelectedRows();
		        int[] selectedColumns = table.getSelectedColumns();

		        for (int i=0;i<selectedRow.length;i++) {
		        	for (int j=0;j<selectedColumns.length;j++) {
		        		selectedData=(String) table.getValueAt(selectedRow[i],selectedColumns[j]);
		        	}
		        }
		        System.out.println("Selected: " + selectedData);
			}
			
		});

		
		tableContainer = new JScrollPane(table);
		tableContainer.setSize(908, 349);
		tableContainer.setLocation(27, 392);
		tableContainer.setBorder(black);
		
		//Start Table 2
		
		columnNames2 = new String[] {
				"Test"
		};
		
		columnContents2 = new String[][] {
				{"TestA"}
		};
		
		table2 = new JTable(columnContents2, columnNames2);
		table2.setSize(1362, 349);
		table2.setLocation(1, 392);
		table2.setBorder(black);
		table2.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				try {
					System.out.println("Row: " + table.getSelectedRow() + "\nColumn: " + table.getSelectedColumn() + "\nInfo: " + table.getModel().getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
				}catch(Exception e) {
					
				}
			}
			
		});
		
		tableContainer2 = new JScrollPane(table2);
		tableContainer2.setSize(363, 349);
		tableContainer2.setLocation(966, 392);
		tableContainer2.setBorder(black);
		
		
		//add all of the components to the frame.
		clientFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		clientCon.add(logout);
		clientCon.add(optionA);
		clientCon.add(optionB);
		clientCon.add(optionC);
		clientCon.add(optionD);
		clientCon.add(tableContainer);
		clientCon.add(tableContainer2);
		
	}
	
	/*
	 * All the methods after this are helper methods for the JTable and whatnot.
	 */
	
	/**
	 * public static void resetTable - this method will remove all information from the jtable and reset the row/column count, so the table can be refilled with new information
	 */
	public static void resetTable(){
		
	}
	
	public static void addTableRows(int newRows, String[][]contents){
		for(int i=0;i!=newRows;i++){
			tableModel.addRow(contents[i]);
		}
	}
	
	/**
	 * public static void addTableRows
	 * @param newRows
	 */
	public static void addTableRows(int newRows){
		for(int i=0;i!=newRows;i++){
			tableModel.addRow(new Object[]{});
		}
	}
	
	public static void addTableColumns(int newColumns){
		for(int i=0;i!=newColumns;i++){
			tableModel.addColumn("");
		}
	}
	
	/**
	 * public static void changeColumnHeadings - this method will update the headers on the JTable to the given 
	 * @param changeTo
	 */
	public static void changeColumnHeadings(String[]changeTo){
		for(int i=0;i!=changeTo.length;i++){
			table.getColumnModel().getColumn(i).setHeaderValue(changeTo[i]);
		}
		table.getTableHeader().repaint(); //redraw the table so that the headers actually show up
	}
	
	
	/**
	 * public static void setLocalValues - this method will take a 3d string from another source, load it into local memory and then into the table.
	 * @param newLocal
	 */
	public static void setLocalValues(String[][][]newLocal){
		localInfo=newLocal;
		setTableTo(localInfo);
	}
	
	/**
	 * public static void setTableTo - fills the JTable with the given information
	 * @param toAdd - the 2d array to fill the table with
	 */
	public static void setTableTo(String[][][]toAdd){
		for(int i=0;i!=toAdd.length;i++){
			for(int f=0;f!=toAdd[i].length;i++){
				table.setValueAt(toAdd[i][f][0], i, f);
			}
		}
	}
	
	/**
	 * public String[][][] getFromTable - this method will return all the values stored locally; INCLUDING the hidden values from the
	 * second table.
	 * @return localInfo - the 3d string array of all the relevant information
	 */
	public String[][][] getFromTable(){
		return localInfo;
	}
	
}
