package src;

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

public class RceivepaymentGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		btnClientId.setBounds(22, 91, 89, 23);
		contentPane.add(btnClientId);
		
		textField = new JTextField();
		textField.setBounds(147, 92, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnPay = new JButton("Enter");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String clientID = textField.getText();
				
				Warehouse warehouse = new Warehouse();
				Client client = warehouse.instance().testClient(clientID);
			  //  return client;
				JOptionPane.showMessageDialog(null, "total balance is" + client.getBalance() );
				PaymentGUI pg = new PaymentGUI();
				pg.setVisible(true);
		       
//		        
//		        Double price = Double.parseDouble(getToken("How much would client like to pay?"));
//		        client.balance = client.balance - price;
//		        System.out.println("Your new balance is " + client.balance);
				
				//JOptionPane.showInputDialog(null, UserInterface.instance().recievePayment());
			}
		});
		btnPay.setBounds(147, 142, 89, 23);
		contentPane.add(btnPay);
	}

}
