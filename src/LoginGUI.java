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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class LoginGUI extends JFrame {

	private JPanel contentPane;

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
		btnNewButton.setBackground(Color.GRAY);
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
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
				
			
				SecuritystateGUI ss = new SecuritystateGUI();
				ss.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(24, 90, 119, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Client Login");
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SecuritystateGUIclient sc = new SecuritystateGUIclient();
				sc.setVisible(true);
				
				
				int clear;
				String clientID = null;
				
				
				 
					
					
				  
			  //  String clientID = getToken("Please input the client id: ");
			    //if (ClientList.instance().checkClient(clientID) != null){
//			      (WarehouseContext.instance()).setLogin(WarehouseContext.IsClient);
//			      (WarehouseContext.instance()).setUser(clientID);      
//			      (WarehouseContext.instance()).changeState(2);
			    
			    // if (false)
			      //System.out.println("Invalid client id.");
			}
		});
		btnNewButton_2.setBounds(24, 152, 119, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblWarehouseLogin = new JLabel("WareHouse Login");
		lblWarehouseLogin.setForeground(new Color(0, 128, 128));
		lblWarehouseLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWarehouseLogin.setIcon(new ImageIcon("C:\\Users\\bikra\\Desktop\\login.png"));
		lblWarehouseLogin.setBounds(187, 13, 181, 30);
		contentPane.add(lblWarehouseLogin);
	}

	protected void close() {
		// TODO Auto-generated method stub
		
	}
}
