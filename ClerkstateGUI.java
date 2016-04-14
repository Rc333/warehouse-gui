package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClerkstateGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtClerkMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClerkstateGUI frame = new ClerkstateGUI();
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
	public ClerkstateGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtClerkMenu = new JTextField();
		txtClerkMenu.setText("CLERK MENU");
		txtClerkMenu.setBounds(145, 11, 86, 20);
		contentPane.add(txtClerkMenu);
		txtClerkMenu.setColumns(10);
		
		JButton btnAddClients = new JButton("Add Clients");
		btnAddClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddClients.setBounds(10, 53, 89, 23);
		contentPane.add(btnAddClients);
		
		JButton btnAddProducts = new JButton("Add products");
		btnAddProducts.setBounds(10, 87, 89, 23);
		contentPane.add(btnAddProducts);
	}
}
