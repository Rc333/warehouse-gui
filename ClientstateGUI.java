

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ClientstateGUI extends JFrame {
	  private static Warehouse warehouse;
	  private ProductList ProductList;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientstateGUI frame = new ClientstateGUI();
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
	public ClientstateGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Show products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				dispose();
//				// return ProductList.getProducts();
				
				String temp ="";
				Iterator allProducts = Warehouse.instance().getProducts();
		        while (allProducts.hasNext()) {
		            Product product = (Product) (allProducts.next());
		            temp+=(product.toString()+"\n");
				
		        }
			  
		        JOptionPane.showMessageDialog(null, temp);
			  
				 
			}}	);
		btnNewButton.setBounds(10, 65, 150, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show waitlist");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 JOptionPane.showMessageDialog(null, Warehouse.instance().getWaitlist());
				
			}
		});
		btnNewButton_1.setBounds(10, 113, 150, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("logout");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\bikra\\Desktop\\cancel.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				if (Clerkstate.instance().CHECKCLIENT==false){
				LoginGUI ls = new LoginGUI();
				ls.setVisible(true);
				}
				else {
					ClerkstateGUI cs = new ClerkstateGUI();
					cs.setVisible(true);
					Clerkstate.instance().CHECKCLIENT=false;
					
				}
			}
		});
		btnNewButton_2.setBounds(297, 65, 100, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblLientMenu = new JLabel("Client menu");
		lblLientMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLientMenu.setBounds(156, 11, 121, 33);
		contentPane.add(lblLientMenu);
	}

}
