package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentGUI frame = new PaymentGUI();
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
	public PaymentGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHowMuchYou = new JLabel("How much you like pay");
		lblHowMuchYou.setBounds(113, 80, 146, 14);
		contentPane.add(lblHowMuchYou);
		
		textField = new JTextField();
		textField.setBounds(123, 107, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Integer price = Integer.parseInt(textField.getText());
			        
				Double balance = 0.0;
				Client client = new Client();
			       balance = client.getBalance();
			       // balance = client.getBalance();
			        balance = balance - price;
			        
			      //  System.out.println("Your new balance is " + client.balance);
			        JOptionPane.showMessageDialog(null, "remaining balance is" + client.getBalance());
				
				
			}
		});
		btnNewButton.setBounds(133, 148, 63, 23);
		contentPane.add(btnNewButton);
	}

}
