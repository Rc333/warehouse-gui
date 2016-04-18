
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnProductName.setBounds(10, 64, 145, 23);
		contentPane.add(btnProductName);

		JButton btnManufacturerName = new JButton("Manufacturer name");
		btnManufacturerName.setBounds(10, 110, 145, 23);
		contentPane.add(btnManufacturerName);

		JButton btnQuantity = new JButton("Quantity");
		btnQuantity.setBounds(10, 158, 145, 23);
		contentPane.add(btnQuantity);

		textField = new JTextField();
		textField.setBounds(183, 64, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(183, 111, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(183, 159, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnReceiveShipment = new JButton("Receive shipment");
		btnReceiveShipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////
				
			}
		});
		btnReceiveShipment.setIcon(new ImageIcon(ReceiveshipmentGUI.class.getResource("/iconimages/imgres.png")));
		btnReceiveShipment.setBounds(37, 194, 169, 46);
		contentPane.add(btnReceiveShipment);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				ClerkstateGUI cs = new ClerkstateGUI();
				cs.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ReceiveshipmentGUI.class.getResource("/iconimages/cancel.png")));
		btnNewButton.setBounds(259, 192, 136, 48);
		contentPane.add(btnNewButton);
	}
}
