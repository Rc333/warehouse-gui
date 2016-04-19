

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RceivepaymentGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RceivepaymentGUI frame = new RceivepaymentGUI();
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
	public RceivepaymentGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientPayment = new JLabel("Client payment");
		lblClientPayment.setBounds(147, 27, 109, 14);
		contentPane.add(lblClientPayment);
		
		JButton btnClientId = new JButton("Client ID");
		btnClientId.setBounds(22, 53, 89, 23);
		contentPane.add(btnClientId);
		
		textField = new JTextField();
		textField.setBounds(147, 54, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setIcon(new ImageIcon(RceivepaymentGUI.class.getResource("/iconimages/login.png")));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String clientID = textField.getText();
				
				Warehouse warehouse = new Warehouse();
				Client client = warehouse.instance().testClient(clientID);
			  //  return client;
				if (client!= null){
					Double oldBalance = client.getBalance();
					Double payment = Double.parseDouble(textField_1.getText());
					client.balance = client.balance - payment;
				
				JOptionPane.showMessageDialog(null, "Old balance was"+ oldBalance  + "The remaining balance is" + client.getBalance() );
				
				
				}
				else{
					JOptionPane.showMessageDialog(null, "Wrong parameter" );
						
				}
			}
		});
		btnPay.setBounds(147, 142, 109, 38);
		contentPane.add(btnPay);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClerkstateGUI cs = new ClerkstateGUI();
				cs.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(RceivepaymentGUI.class.getResource("/iconimages/cancel.png")));
		btnNewButton.setBounds(311, 141, 109, 38);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 89, 86, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnPayment = new JButton("Payment");
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPayment.setBounds(22, 89, 89, 23);
		contentPane.add(btnPayment);
	}
}
