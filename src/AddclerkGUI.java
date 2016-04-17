package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AddclerkGUI extends JFrame {
	private static Warehouse warehouse;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddclerkGUI frame = new AddclerkGUI();
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
	public AddclerkGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnName = new JButton("Name");
		btnName.setBounds(10, 56, 89, 23);
		contentPane.add(btnName);
		
		JButton btnAddress = new JButton("Address");
		btnAddress.setBounds(10, 90, 89, 23);
		contentPane.add(btnAddress);
		
		JButton btnPhone = new JButton("Phone");
		btnPhone.setBounds(10, 135, 89, 23);
		contentPane.add(btnPhone);
		
		textField = new JTextField();
		textField.setBounds(187, 57, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 91, 137, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 136, 137, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblClerkMenu = new JLabel("Please Specify Client Credentials");
		lblClerkMenu.setBounds(88, 13, 214, 14);
		contentPane.add(lblClerkMenu);
		
		JButton btnAddClient = new JButton("Add Client");
		btnAddClient.setIcon(new ImageIcon(AddclerkGUI.class.getResource("/iconimages/Button-Add-icon.png")));
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				String name = textField.getText();
				String address = textField_1.getText();
				String phone = textField_2.getText();
		        Client result;
		        System.out.println(name + address + phone);
		        result = warehouse.instance().addClient(name, address, phone);
		        if (result == null) {
		        	JLabel labelClerk = new JLabel("invalid user");
		    		labelClerk.setBounds(10, 236, 46, 14);
		    		contentPane.add(labelClerk);
		        }
		        JOptionPane.showMessageDialog(null, result);
		        
		        ClerkstateGUI csG = new ClerkstateGUI();
		        csG.setVisible(true);
				
			}
		});
		btnAddClient.setBounds(187, 182, 137, 33);
		contentPane.add(btnAddClient);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon(AddclerkGUI.class.getResource("/iconimages/cancel.png")));
		btnLogout.setBounds(10, 182, 106, 33);
		contentPane.add(btnLogout);
		
		
	}
}
