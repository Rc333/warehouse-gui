package src;

import static java.lang.Boolean.FALSE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ClerkstateGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnSave;
	private JLabel lblClerkMenu;
	private JLabel clerkLabel;
	protected boolean CHECKCLIENT = FALSE;
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

		JButton btnAddClients = new JButton("Add Clients");
		btnAddClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddclerkGUI ac = new AddclerkGUI();
				ac.setVisible(true);

			}
		});
		btnAddClients.setBounds(10, 53, 144, 23);
		contentPane.add(btnAddClients);

		JButton btnAddProducts = new JButton("Add products");
		btnAddProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddproductGUI ap = new AddproductGUI();
				ap.setVisible(true);
				
			}
		});
		btnAddProducts.setBounds(10, 87, 144, 23);
		contentPane.add(btnAddProducts);

		btnNewButton = new JButton("Process order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProcessorderGUI po = new ProcessorderGUI();
				po.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 121, 144, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Receive shipment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ReceiveshipmentGUI rs = new ReceiveshipmentGUI();
				rs.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(10, 155, 144, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Receive payment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RceivepaymentGUI rp = new RceivepaymentGUI();
				rp.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(10, 192, 144, 23);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new JButton("Get transactions");
		btnNewButton_3.setBounds(10, 226, 144, 23);
		contentPane.add(btnNewButton_3);

		btnNewButton_4 = new JButton("logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
//				if( CHECKCLIENT == FALSE)
//				{
//					LoginGUI lg = new LoginGUI();
//					lg.setVisible(true);
//				}
//				else{
//					ManagerstateGUI ms = new ManagerstateGUI();
//					ms.setVisible(true);
//				}
					
				
			}
		});
		btnNewButton_4.setBounds(334, 71, 89, 23);
		contentPane.add(btnNewButton_4);

		btnSave = new JButton("save");
		btnSave.setBounds(334, 35, 89, 23);
		contentPane.add(btnSave);

		lblClerkMenu = new JLabel("Clerk Menu");
		lblClerkMenu.setBounds(155, 11, 124, 14);
		contentPane.add(lblClerkMenu);

		JButton btnClientMenu = new JButton("Client Menu");
		btnClientMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
				String clientID = JOptionPane.showInputDialog(null, "Please input the user id: ");
				if (ClientList.instance().checkClient(clientID) != null) {
					ClientstateGUI cs = new ClientstateGUI();
					dispose();
					cs.setVisible(true);
				}
				else {clerkLabel.setText("Error Retrieving Clients");}

			}
		});
		btnClientMenu.setBounds(308, 179, 115, 25);
		contentPane.add(btnClientMenu);
		
		clerkLabel = new JLabel("");
		clerkLabel.setBounds(244, 229, 138, 16);
		contentPane.add(clerkLabel);
	}
}
