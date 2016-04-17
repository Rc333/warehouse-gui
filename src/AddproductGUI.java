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
import javax.swing.ImageIcon;

public class AddproductGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddproductGUI frame = new AddproductGUI();
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
	public AddproductGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddingProducts = new JLabel("Adding products");
		lblAddingProducts.setBounds(148, 27, 149, 14);
		contentPane.add(lblAddingProducts);
		
		JButton btnNewButton = new JButton("product name");
		btnNewButton.setBounds(10, 65, 126, 23);
		contentPane.add(btnNewButton);
		
		JButton btnProductId = new JButton("Product ID");
		btnProductId.setBounds(10, 101, 126, 23);
		contentPane.add(btnProductId);
		
		JButton btnManufacturer = new JButton("Manufacturer");
		btnManufacturer.setBounds(10, 137, 126, 23);
		contentPane.add(btnManufacturer);
		
		JButton btnPrice = new JButton("price");
		btnPrice.setBounds(10, 173, 126, 23);
		contentPane.add(btnPrice);
		
		JButton btnQuantity = new JButton("Quantity");
		btnQuantity.setBounds(10, 211, 126, 23);
		contentPane.add(btnQuantity);
		
		textField = new JTextField();
		textField.setBounds(148, 66, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 102, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 138, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(148, 174, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(148, 212, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.setIcon(new ImageIcon(AddproductGUI.class.getResource("/iconimages/Button-Add-icon.png")));
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField.getText();
				String productID = textField_1.getText();
				String manufacturer = textField_2.getText();  
	            Double price = Double.parseDouble(textField_3.getText());
                Integer quantity = Integer.parseInt(textField_3.getText());
				Product result;
		            result = Warehouse.instance().addProduct(name, manufacturer, productID, price, quantity);
		            if (result == null) {
			        	JLabel labelClerk = new JLabel("invalid user");
			    		labelClerk.setBounds(10, 236, 46, 14);
			    		contentPane.add(labelClerk);
			        }
			        JOptionPane.showMessageDialog(null, result);
			        
			        ClerkstateGUI csG = new ClerkstateGUI();
			        csG.setVisible(true);
				
				
				
			}
		});
		btnAddProduct.setBounds(126, 247, 126, 36);
		contentPane.add(btnAddProduct);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setIcon(new ImageIcon(AddproductGUI.class.getResource("/iconimages/cancel.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClientstateGUI cs = new ClientstateGUI();
				cs.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(287, 247, 111, 36);
		contentPane.add(btnNewButton_1);
	}
}
