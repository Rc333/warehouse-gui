package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class ShowinvoicesGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowinvoicesGUI frame = new ShowinvoicesGUI();
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
	public ShowinvoicesGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClientid = new JButton("ClientID");
		btnClientid.setBounds(23, 67, 89, 23);
		contentPane.add(btnClientid);
		
		textField = new JTextField();
		textField.setBounds(155, 68, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnInvoice = new JButton("Invoice");
		btnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String clientID = textField.getText();
				 String cat = "";
			        InvoiceList testInvoice = InvoiceList.instance();
			        Iterator testIterator = testInvoice.getInvoices();
			        while (testIterator.hasNext()) {
			            Invoice tempTest = (Invoice) testIterator.next();
			            tempTest = testInvoice.checkInvoice(clientID);
			            if (tempTest != null) {
			                cat = cat + (tempTest.getInvoiceString() + "\n");
			            }
			        }
			        //return cat;
			        JOptionPane.showMessageDialog(null, cat);
				
				
			}
		});
		btnInvoice.setBounds(152, 124, 89, 23);
		contentPane.add(btnInvoice);
	}

}
