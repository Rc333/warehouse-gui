package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

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
		setBounds(100, 100, 482, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblManagerMenu = new JLabel("Manager menu");
		lblManagerMenu.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblManagerMenu.setBounds(165, 13, 155, 22);
		contentPane.add(lblManagerMenu);
		
		JButton btnAddManufacturer = new JButton("Add manufacturer");
		btnAddManufacturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddmanufacturerGUI am = new AddmanufacturerGUI();
				am.setVisible(true);
				
			}
		});
		btnAddManufacturer.setBounds(10, 59, 144, 23);
		contentPane.add(btnAddManufacturer);
		
		JButton btnShowClients = new JButton("Show clients");
		btnShowClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				 JOptionPane.showMessageDialog(null, Warehouse.instance().getClients());
				
			}
		});
		btnShowClients.setBounds(10, 95, 144, 23);
		contentPane.add(btnShowClients);
		
		JButton btnShowProducts = new JButton("Show products");
		btnShowProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JOptionPane.showMessageDialog(null, Warehouse.instance().getProducts());
				
				
			}
		});
		btnShowProducts.setBounds(10, 131, 144, 23);
		contentPane.add(btnShowProducts);
		
		JButton btnShowInvoices = new JButton("Show invoices");
		btnShowInvoices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShowinvoicesGUI si = new ShowinvoicesGUI();
				si.setVisible(true);
				
				
			}
		});
		btnShowInvoices.setBounds(10, 167, 144, 23);
		contentPane.add(btnShowInvoices);
		
		JButton btnShowWaitlist = new JButton("Show waitlist");
		btnShowWaitlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(null, Warehouse.instance().getWaitlist());
				
				
			}
		});
		btnShowWaitlist.setBounds(10, 203, 144, 23);
		contentPane.add(btnShowWaitlist);
		
		JButton btnClerkMenu = new JButton("Clerk menu");
		btnClerkMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Managerstate.instance().CHECKMANAGER=true;
				dispose();
				ClerkstateGUI cs = new ClerkstateGUI();
				cs.setVisible(true);
				
			}
		});
		btnClerkMenu.setBounds(10, 239, 144, 23);
		contentPane.add(btnClerkMenu);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon("C:\\Users\\bikra\\Desktop\\cancel.png"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginGUI lg = new LoginGUI();
				lg.setVisible(true);
				
			}
		});
		btnLogout.setBounds(320, 65, 116, 41);
		contentPane.add(btnLogout);
	}

}
