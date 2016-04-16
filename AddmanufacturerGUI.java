package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AddmanufacturerGUI extends JFrame {

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
					AddmanufacturerGUI frame = new AddmanufacturerGUI();
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
	public AddmanufacturerGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnName = new JButton("name");
		btnName.setBounds(10, 52, 89, 23);
		contentPane.add(btnName);
		
		JButton btnId = new JButton("ID");
		btnId.setBounds(10, 108, 89, 23);
		contentPane.add(btnId);
		
		textField = new JTextField();
		textField.setBounds(131, 53, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 109, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAddManufacturer = new JButton("Add manufacturer");
		btnAddManufacturer.setBounds(128, 177, 137, 23);
		contentPane.add(btnAddManufacturer);
	}
}
