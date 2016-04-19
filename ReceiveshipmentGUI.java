
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class ReceiveshipmentGUI extends JFrame {

	private JPanel contentPane;
	private JTextField productName;
	private JTextField manufactureName;
	private JTextField quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiveshipmentGUI frame = new ReceiveshipmentGUI();
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
	public ReceiveshipmentGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblReceivingAShipment = new JLabel("Receiving a shipment");
		lblReceivingAShipment.setBounds(147, 37, 122, 14);
		contentPane.add(lblReceivingAShipment);

		JButton btnProductName = new JButton("Product name");
		btnProductName.setBounds(10, 64, 145, 23);
		contentPane.add(btnProductName);

		JButton btnManufacturerName = new JButton("Manufacturer name");
		btnManufacturerName.setBounds(10, 110, 145, 23);
		contentPane.add(btnManufacturerName);

		JButton btnQuantity = new JButton("Quantity");
		btnQuantity.setBounds(10, 158, 145, 23);
		contentPane.add(btnQuantity);

		productName = new JTextField();
		productName.setBounds(183, 64, 86, 20);
		contentPane.add(productName);
		productName.setColumns(10);

		manufactureName = new JTextField();
		manufactureName.setBounds(183, 111, 86, 20);
		contentPane.add(manufactureName);
		manufactureName.setColumns(10);

		quantity = new JTextField();
		quantity.setBounds(183, 159, 86, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);

		JButton btnReceiveShipment = new JButton("Receive shipment");
		btnReceiveShipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				////

				Boolean status = false;
				String productname = productName.getText();
				String manufacturerName = manufactureName.getText();
				Integer quantityField = Integer.parseInt(quantity.getText());

				Iterator<Product> pdtList = Warehouse.instance().getProducts();
				while (pdtList.hasNext()) {
					Product pdtCheck = (Product) pdtList.next();
					if (manufacturerName.equals(pdtCheck.getManufacturer())
							&& productname.equals(pdtCheck.getProductName())) {
						{
							status = true;
							// System.out.println("product match");
							pdtCheck.quantity += quantityField;
							JOptionPane.showMessageDialog(null, "new quantity " + pdtCheck.quantity);

						}

					}
				}
				if (status == false) {
					JOptionPane.showMessageDialog(null, "No previous record found, please add thorugh add products!!");

				}

				Iterator wtList = Warehouse.instance().getWaitlist();
				while (wtList.hasNext()) {
					Waititem waitCheck = (Waititem) wtList.next();
					if (productname.equals(waitCheck.getWaititemName().getProductName())
							&& waitCheck.waitQuantity() < waitCheck.getWaititemName().quantity) {
						JOptionPane.showMessageDialog(null, "Pending Order Found, Processing");
						Date date = new Date();
						// issue product and write to the invoice
						Invoice tempInvoice = new Invoice(waitCheck.getWaititemName(), waitCheck.waitClient(),
								waitCheck.waitQuantity(), date);
						InvoiceList invoiceList = InvoiceList.instance();

						if (invoiceList.insertInvoices(tempInvoice)) {
							JOptionPane.showMessageDialog(null, "FILLING OUT THE ORDER FOR CLIENT: "
									+ waitCheck.waitClient().getName() + tempInvoice.getInvoiceString());

							waitCheck.getWaititemName().decQuantity(waitCheck.waitQuantity());
							waitCheck.waitClient().addBalance(tempInvoice.sum);
							Warehouse.instance().insertTransaction(waitCheck.waitClient(), waitCheck.getWaititemName(),
									date);
							wtList.remove();

							dispose();
							ClerkstateGUI cs = new ClerkstateGUI();
							cs.setVisible(true);

						}

					}

				}

				//////

			}
		});
		btnReceiveShipment.setIcon(new ImageIcon(ReceiveshipmentGUI.class.getResource("/iconimages/imgres.png")));
		btnReceiveShipment.setBounds(10, 193, 194, 46);
		contentPane.add(btnReceiveShipment);

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				ClerkstateGUI cs = new ClerkstateGUI();
				cs.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ReceiveshipmentGUI.class.getResource("/iconimages/cancel.png")));
		btnNewButton.setBounds(259, 192, 136, 48);
		contentPane.add(btnNewButton);
	}
}
