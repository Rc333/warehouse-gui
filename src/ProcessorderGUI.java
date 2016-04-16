package src;

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

public class ProcessorderGUI extends JFrame {
	 private static Warehouse warehouse;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		btnUserId.setBounds(10, 62, 89, 23);
		contentPane.add(btnUserId);
		
		JButton btnProductId = new JButton("Product ID");
		btnProductId.setBounds(10, 114, 89, 23);
		contentPane.add(btnProductId);
		
		JButton btnQuantity = new JButton("Quantity");
		btnQuantity.setBounds(10, 163, 89, 23);
		contentPane.add(btnQuantity);
		
		JLabel lblProcessingClientOrder = new JLabel("Processing Client order");
		lblProcessingClientOrder.setBounds(125, 22, 140, 14);
		contentPane.add(lblProcessingClientOrder);
		
		textField = new JTextField();
		textField.setBounds(125, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 115, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 164, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnOrderItem = new JButton("Order Item");
		btnOrderItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String clientID = textField.getText();
				// String clientID = getToken("Enter User ID");
			        Client client = warehouse.testClient(clientID);
			        if (client == null) {
			        	JLabel labelClerk = new JLabel("invalid client");
			    		labelClerk.setBounds(10, 236, 46, 14);
			    		contentPane.add(labelClerk);
			        } else {

			      

			                // do while loop here to ask for books. 
			            	String productID = textField_1.getText();
			               // String productID = getToken("Enter Product ID");
			                if (warehouse.testProduct(productID) != null) {
			                    Integer quantity = Integer.parseInt(textField_2.getText());
			                    if (warehouse.instance().issueProduct(client, productID, quantity)) {
			                  //   result;
			                   //result = warehouse.instance().issueProduct(client, productID, quantity);
			                    	JOptionPane.showMessageDialog(null, warehouse.instance().issueProduct(client, productID, quantity));
			                    }

			                } else {
			                   // System.out.println("Product does not exist");
			                	JLabel labelClerk = new JLabel("product doesnot exist");
					    		labelClerk.setBounds(10, 236, 46, 14);
					    		contentPane.add(labelClerk);
			                }

//			                if (!yesOrNo("Add more products?")) {
//			                    break;
//			                }
//			            } while (true);
				
				
			}}
		});
		btnOrderItem.setBounds(125, 210, 89, 23);
		contentPane.add(btnOrderItem);
	}

}
