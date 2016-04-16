package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ReceiveshipmentGUI extends JFrame {

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
					ReceiveshipmentGUI frame = new ReceiveshipmentGUI();
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
	public ReceiveshipmentGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReceivingAShipment = new JLabel("Receiving a shipment");
		lblReceivingAShipment.setBounds(147, 37, 122, 14);
		contentPane.add(lblReceivingAShipment);
		
		JButton btnProductName = new JButton("Product name");
		btnProductName.setBounds(10, 90, 89, 23);
		contentPane.add(btnProductName);
		
		JButton btnManufacturerName = new JButton("Manufacturer name");
		btnManufacturerName.setBounds(10, 144, 89, 23);
		contentPane.add(btnManufacturerName);
		
		JButton btnQuantity = new JButton("Quantity");
		btnQuantity.setBounds(10, 194, 89, 23);
		contentPane.add(btnQuantity);
		
		textField = new JTextField();
		textField.setBounds(147, 91, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 145, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(147, 195, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnReceiveShipment = new JButton("Receive shipment");
		btnReceiveShipment.setBounds(144, 227, 156, 23);
		contentPane.add(btnReceiveShipment);
	}

}
