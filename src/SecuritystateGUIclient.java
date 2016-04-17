package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SecuritystateGUIclient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecuritystateGUIclient frame = new SecuritystateGUIclient();
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
	public SecuritystateGUIclient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("client id");
		btnNewButton.setBounds(21, 60, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(155, 61, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientstateGUI cs = new ClientstateGUI();
				String iput = textField.getText();
				//cs.setVisible(true);
				String clientID = iput;
				//System.out.println(iput + iput1);
				if (Warehouse.instance().testClient(clientID ) != null) {
					
					//System.out.println(clientID);
					dispose();   
					cs.setVisible(true);
				

				 }	
				else{
					lblNewLabel = new JLabel("invalid user id");
					lblNewLabel.setBounds(44, 221, 167, 14);
					contentPane.add(lblNewLabel);
					lblNewLabel.setText("Invalid user/pass");
				}
			
				
			}
		});
		btnLogin.setBounds(152, 138, 89, 23);
		contentPane.add(btnLogin);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginGUI lg = new LoginGUI();
				lg.setVisible(true);
				
			}
		});
		btnCancel.setIcon(new ImageIcon("C:\\Users\\bikra\\Desktop\\cancel.png"));
		btnCancel.setBounds(21, 137, 119, 25);
		contentPane.add(btnCancel);
		
		
	}

}
