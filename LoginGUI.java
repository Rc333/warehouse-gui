package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Clerk Login");
		btnNewButton.setBackground(new Color(153, 51, 153));
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				//setVisible(false);
				//LoginGUI ls = new LoginGUI();
				//ls.setVisible(false);
			
				SecuritystateGUI ss = new SecuritystateGUI();
				ss.setVisible(true);
				
			  
			/*	SecuritystateGUI securitystategui;
				  securitystategui = new SecuritystateGUI();
				int clear;
//				Securitystate sc = new Securitystate();
				if(SecuritystateGUI.clerkSecurity(true))
				{ 
					//  Loginstate clerk;
					//if (Securitystate.clerkSecurity(clerk))
			     
				 // String clerkname = getToken("Please input the clerk name: ");
				  //String clerkID = getToken("Please input the clerk id: ");
				 // if( clerkname.equals("CLERK") && clerkID.equals("CLERK"))
				  //{
			    (WarehouseContext.instance()).setLogin(WarehouseContext.IsClerk);
			    (WarehouseContext.instance()).changeState(0);*/
			    
				//  } 
				//if(false) 
					//  System.out.println("invalid id/uname(type both as CLERK)");
				      
			}
		});
		btnNewButton.setBounds(24, 35, 119, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Manager Login");
		btnNewButton_1.setBackground(new Color(153, 51, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Securitystate securitystate;
				securitystate = new Securitystate();
				int clear;
				//Securitystate sc = new Securitystate();
				if(Securitystate.managerSecurity(true))
				{ 
					//  Loginstate clerk;
					//if (Securitystate.clerkSecurity(clerk))

				// String clerkname = getToken("Please input the clerk name: ");
				//String clerkID = getToken("Please input the clerk id: ");
				// if( clerkname.equals("CLERK") && clerkID.equals("CLERK"))
				//{
					(WarehouseContext.instance()).setLogin(WarehouseContext.IsManager);
				    (WarehouseContext.instance()).changeState(1);
				} 
				if(false) 
					  System.out.println("invalid id/uname(type both as CLERK)");
					  
			}
		});
		btnNewButton_1.setBounds(24, 90, 119, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Client Login");
		btnNewButton_2.setBackground(new Color(153, 51, 204));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Securitystate securitystate;
				  securitystate = new Securitystate();
				int clear;
				String clientID = null;
				Securitystate sc = new Securitystate();
				if(securitystate.clientSecurity(true));
				{ 
					
					
				  
			  //  String clientID = getToken("Please input the client id: ");
			    //if (ClientList.instance().checkClient(clientID) != null){
			      (WarehouseContext.instance()).setLogin(WarehouseContext.IsClient);
			      (WarehouseContext.instance()).setUser(clientID);      
			      (WarehouseContext.instance()).changeState(2);
			    }
			     if (false)
			      System.out.println("Invalid client id.");
			}
		});
		btnNewButton_2.setBounds(24, 152, 119, 23);
		contentPane.add(btnNewButton_2);
		
		txtLoginPage = new JTextField();
		txtLoginPage.setBackground(new Color(153, 255, 204));
		txtLoginPage.setText("LOGIN PAGE");
		txtLoginPage.setBounds(149, 11, 86, 20);
		contentPane.add(txtLoginPage);
		txtLoginPage.setColumns(10);
	}

	protected void close() {
		// TODO Auto-generated method stub
		
	}
}
