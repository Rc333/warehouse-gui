package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class SecuritystateGUI extends JFrame {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
	
	private JPanel contentPane;
	private JTextField txtUserId;
	private JTextField txtPassword;
	private JPasswordField passwordField;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecuritystateGUI frame = new SecuritystateGUI();
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
	public SecuritystateGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUserId = new JTextField();
		txtUserId.setBackground(new Color(204, 153, 204));
		txtUserId.setText("User id");
		txtUserId.setBounds(10, 61, 86, 20);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);
		
		
		txtPassword = new JTextField();
		txtPassword.setBackground(new Color(204, 153, 204));
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 110, 86, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addContainerListener(new ContainerAdapter() {
			// String clerkID = getToken("Please input the clerk id: ");
			//@Override
			public void componentAdded(ContainerEvent e) {
				String iput1 = passwordField.getText();	
			}
		});
		passwordField.setBackground(new Color(255, 255, 204));
		passwordField.setBounds(126, 110, 86, 20);
		contentPane.add(passwordField);
		
		final JTextArea textArea = new JTextArea();
		textArea.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		textArea.addContainerListener(new ContainerAdapter() {
			//@Override
			
			public void componentAdded(ContainerEvent arg0) {
				
			//	 String clerkname = getToken("Please input the clerk name: ");
		String iput = textArea.getText();	
		//System.out.println(iput);
			}
		});
		textArea.setBackground(new Color(255, 255, 204));
		textArea.setBounds(126, 60, 86, 20);
		contentPane.add(textArea);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(0, 102, 102));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//setVisible(false);
				ClerkstateGUI cs = new ClerkstateGUI();
				ManagerstateGUI ms = new ManagerstateGUI();
				String iput = textArea.getText();
				String iput1 = passwordField.getText();	
				//System.out.println(iput + iput1);
				if (iput.equals("CLERK") && iput1.equals("CLERK")) {
					dispose();   
					cs.setVisible(true);
				

				 }	
				else if(iput.equals("MANAGER") && iput1.equals("MANAGER")){
					dispose();
					ms.setVisible(true);
				}
				
				else {
					JLabel lblNewLabel = new JLabel("Invalid User Name Password");
					lblNewLabel.setBounds(10, 217, 140, 14);
					contentPane.add(lblNewLabel);
					lblNewLabel.setText("Invalid user/pass");
					
					
				}//return null != null;
					
						  
				  
				 //manager 
				/*public static boolean managerSecurity(boolean b){
					// Securitystate sc = new Securitystate();
					  String managername = getToken("Please input the manager name: ");
					  String managerID = getToken("Please input the manager id: ");
					  if( managername.equals("MANAGER") && managerID.equals("MANAGER"))
					  {
						  return true;
					  // (WarehouseContext.instance()).setLogin(WarehouseContext.IsManager);
					    //(WarehouseContext.instance()).changeState(1);
					  }
					  else 
						  System.out.println("invalid id/uname(type both as MANAGER)");
					 return (false); 
				}
					  
				public static boolean clientSecurity(boolean b){
					// Securitystate sc = new Securitystate();
				    String clientID = getToken("Please input the client id: ");
				    if (ClientList.instance().checkClient(clientID) != null){
				    	
				    //	(WarehouseContext.instance()).setLogin(WarehouseContext.IsClient);
					    //(WarehouseContext.instance()).setUser(clientID);      
				    	
				    	return (true);
				    }
				   
				    
				     // (WarehouseContext.instance()).setLogin(WarehouseContext.IsClient);
				      //(WarehouseContext.instance()).setUser(clientID);      
				      //(WarehouseContext.instance()).changeState(2);
				    //}
				    else 
				      System.out.println("Invalid client id.");
				     return (false);
				    	  
				}*/

				
			}});
		btnLogin.setBounds(142, 165, 110, 23);
		contentPane.add(btnLogin);
		
		JButton btnClear = new JButton("clear");
		btnClear.setBackground(new Color(204, 204, 102));
		btnClear.setBounds(26, 165, 104, 23);
		contentPane.add(btnClear);
		
		JLabel lblEnterUserId = new JLabel("Enter User ID and Password");
		lblEnterUserId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterUserId.setForeground(Color.GRAY);
		lblEnterUserId.setBounds(89, 13, 224, 33);
		contentPane.add(lblEnterUserId);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.GRAY);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginGUI lg = new LoginGUI();
				lg.setVisible(true);
			
			}
		});
		btnCancel.setIcon(new ImageIcon("C:\\Users\\bikra\\Desktop\\cancel.png"));
		btnCancel.setBounds(292, 164, 104, 25);
		contentPane.add(btnCancel);
		
		
	}
		public boolean clerkSecurityb(boolean b) {
			// TODO Auto-generated method stub
			return false;
	}
		
		public static String getToken(String prompt) {
		    do {
		      try {
		        System.out.println(prompt);
		        String line = reader.readLine();
		        StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
		        if (tokenizer.hasMoreTokens()) {
		          return tokenizer.nextToken();
		        }
		      } catch (IOException ioe) {
		        System.exit(0);
		      }
		    } while (true);
		  }

		public static boolean clerkSecurity(boolean b) {
			// TODO Auto-generated method stub
			 String clerkname = getToken("Please input the clerk name: ");
		        String clerkID = getToken("Please input the clerk id: ");
		        if (clerkname.equals("CLERK") && clerkID.equals("CLERK")) {

		            return (true);
			    //(WarehouseContext.instance()).setLogin(WarehouseContext.IsClerk);
		            //(WarehouseContext.instance()).changeState(0);
		            //} 
		        } else {
		            System.out.println("invalid id/uname(type both as CLERK)");
		        }

		        return (false);
		}
}
	
