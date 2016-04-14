package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class AddclerkGUI extends JFrame {

	private JPanel contentPane;

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
	}

}
