package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerstateGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerstateGUI frame = new ManagerstateGUI();
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
	public ManagerstateGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManagerMenu = new JLabel("Manager menu");
		lblManagerMenu.setBounds(150, 24, 130, 14);
		contentPane.add(lblManagerMenu);
		
		JButton btnAddManufacturer = new JButton("Add manufacturer");
		btnAddManufacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddmanufacturerGUI am = new AddmanufacturerGUI();
				am.setVisible(true);
				
			}
		});
		btnAddManufacturer.setBounds(10, 59, 130, 23);
		contentPane.add(btnAddManufacturer);
		
		JButton btnShowClients = new JButton("Show clients");
		btnShowClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ShowclientsGUI sc = new ShowclientsGUI();
				sc.setVisible(true);
				
			}
		});
		btnShowClients.setBounds(10, 104, 130, 23);
		contentPane.add(btnShowClients);
		
		JButton btnShowProducts = new JButton("Show products");
		btnShowProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowproductsGUI sp = new ShowproductsGUI();
				sp.setVisible(true);
				
			}
		});
		btnShowProducts.setBounds(10, 145, 130, 23);
		contentPane.add(btnShowProducts);
		
		JButton btnShowInvoices = new JButton("Show invoices");
		btnShowInvoices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShowinvoicesGUI si = new ShowinvoicesGUI();
				si.setVisible(true);
		
				
			}
		});
		btnShowInvoices.setBounds(10, 194, 130, 23);
		contentPane.add(btnShowInvoices);
		
		JButton btnShowWaitlist = new JButton("Show waitlist");
		btnShowWaitlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShowwaitlistGUI sw = new ShowwaitlistGUI();
				sw.setVisible(true);
				
				
			}
		});
		btnShowWaitlist.setBounds(10, 228, 130, 23);
		contentPane.add(btnShowWaitlist);
		
		JButton btnClerkMenu = new JButton("Clerk menu");
		btnClerkMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClerkstateGUI cs = new ClerkstateGUI();
				cs.setVisible(true);
				
			}
		});
		btnClerkMenu.setBounds(197, 59, 89, 23);
		contentPane.add(btnClerkMenu);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLogout.setBounds(197, 104, 89, 23);
		contentPane.add(btnLogout);
	}

}
