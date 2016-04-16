package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

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
		
		JLabel lblClientPayment = new JLabel("C;lient payment");
		lblClientPayment.setBounds(147, 27, 109, 14);
		contentPane.add(lblClientPayment);
		
		JButton btnClientId = new JButton("Client ID");
		btnClientId.setBounds(22, 91, 89, 23);
		contentPane.add(btnClientId);
		
		textField = new JTextField();
		textField.setBounds(147, 92, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(144, 186, 89, 23);
		contentPane.add(btnPay);
		
		JButton btnAmount = new JButton("amount");
		btnAmount.setBounds(22, 136, 89, 23);
		contentPane.add(btnAmount);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 137, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

}
