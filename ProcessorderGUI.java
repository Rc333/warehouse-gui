

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ProcessorderGUI extends JFrame {
//	 private static Warehouse warehouse;
	private JPanel contentPane;
	private JTextField userIdField;
	private JTextField productField;
	private JTextField quantityField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcessorderGUI frame = new ProcessorderGUI();
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
	public ProcessorderGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUserId = new JButton("User id");
		btnUserId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUserId.setBounds(10, 62, 103, 23);
		contentPane.add(btnUserId);
		
		JButton btnProductId = new JButton("Product ID");
		btnProductId.setBounds(10, 114, 103, 23);
		contentPane.add(btnProductId);
		
		JButton btnQuantity = new JButton("Quantity");
		btnQuantity.setBounds(10, 163, 103, 23);
		contentPane.add(btnQuantity);
		
		JLabel lblProcessingClientOrder = new JLabel("Processing Client order");
		lblProcessingClientOrder.setBounds(125, 22, 140, 14);
		contentPane.add(lblProcessingClientOrder);
		
		userIdField = new JTextField();
		userIdField.setBounds(125, 63, 86, 20);
		contentPane.add(userIdField);
		userIdField.setColumns(10);
		
		productField = new JTextField();
		productField.setBounds(125, 115, 86, 20);
		contentPane.add(productField);
		productField.setColumns(10);
		
		quantityField = new JTextField();
		quantityField.setBounds(125, 164, 86, 20);
		contentPane.add(quantityField);
		quantityField.setColumns(10);
		
		JButton btnOrderItem = new JButton("Order ");
		btnOrderItem.setIcon(new ImageIcon(ProcessorderGUI.class.getResource("/iconimages/imgres.png")));
		btnOrderItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String clientID = userIdField.getText();
				// String clientID = getToken("Enter User ID");
			        Client client = Warehouse.instance().testClient(clientID);
			        if (client == null) {
			        	//testing process order
			        	
			        	
			        	
			        	JLabel labelClerk = new JLabel("invalid client");
			    		labelClerk.setBounds(10, 236, 46, 14);
			    		contentPane.add(labelClerk);
			        } else {
			        	//System.out.println("Client Verified");

			      

			                // do while loop here to ask for books. 
			            	String productID = productField.getText();
			               // String productID = getToken("Enter Product ID");
			            	
			                if (Warehouse.instance().testProduct(productID) != null) {
			                	//System.out.println("Product Verified");
			                	
			                    Integer quantity = Integer.parseInt(quantityField.getText());
			                    if (Warehouse.instance().issueProduct(client, productID, quantity)) {
			                    	//System.out.println("Product Issue Verified");
			                  //   result;
			                   //result = warehouse.instance().issueProduct(client, productID, quantity);
			                    	//JOptionPane.showMessageDialog(null, Warehouse.instance().issueProduct(client, productID, quantity));
			                    dispose();
			                    ClerkstateGUI cs = new ClerkstateGUI();
			                    cs.setVisible(true);
			                    }

			                } else {
			                    System.out.println("Product does not exist");
			                	JLabel labelClerk = new JLabel("product doesnot exist");
					    		labelClerk.setBounds(10, 236, 46, 14);
					    		contentPane.add(labelClerk);
			                }

				
			}}
		});
		btnOrderItem.setBounds(125, 197, 140, 44);
		contentPane.add(btnOrderItem);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClerkstateGUI csg = new ClerkstateGUI();
				csg.setVisible(true);
			}
		});
		btnCancel.setIcon(new ImageIcon(ProcessorderGUI.class.getResource("/iconimages/cancel.png")));
		btnCancel.setBounds(278, 197, 123, 44);
		contentPane.add(btnCancel);
	}
}
