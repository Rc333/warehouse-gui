package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProcessorderGUI extends JFrame {

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
					ProcessorderGUI frame = new ProcessorderGUI();
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
	public ProcessorderGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUserId = new JButton("User id");
		btnUserId.setBounds(10, 62, 89, 23);
		contentPane.add(btnUserId);
		
		JButton btnProductId = new JButton("Product ID");
		btnProductId.setBounds(10, 114, 89, 23);
		contentPane.add(btnProductId);
		
		JButton btnQuantity = new JButton("Quantity");
		btnQuantity.setBounds(10, 163, 89, 23);
		contentPane.add(btnQuantity);
		
		JLabel lblProcessingClientOrder = new JLabel("Processing Client order");
		lblProcessingClientOrder.setBounds(125, 22, 140, 14);
		contentPane.add(lblProcessingClientOrder);
		
		textField = new JTextField();
		textField.setBounds(125, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 115, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 164, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnOrderItem = new JButton("Order Item");
		btnOrderItem.setBounds(125, 210, 89, 23);
		contentPane.add(btnOrderItem);
	}

}
