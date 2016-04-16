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

public class WarehousecontextGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarehousecontextGUI frame = new WarehousecontextGUI();
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
	public WarehousecontextGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToWarehousex = new JLabel("Welcome to warehouse1.x");
		lblWelcomeToWarehousex.setBounds(150, 34, 175, 14);
		contentPane.add(lblWelcomeToWarehousex);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 //private void retrieve() {
				        try {
				            Warehouse tempWarehouse = Warehouse.retrieve();
				            if (tempWarehouse != null) {
				                dispose();
				                LoginGUI lg = new LoginGUI();
				                lg.setVisible(true);
				            	//System.out.println(" The warehouse has been successfully retrieved from the file WarehouseData \n");
				               // warehouse = tempWarehouse;
				            } else {
				                System.out.println("File doesnt exist; creating new warehouse");
				                //warehouse = Warehouse.instance();
				            }
				        } catch (Exception cnfe) {
				            cnfe.printStackTrace();
				        }
				    }
				 
				 
			
		});
		btnYes.setBounds(132, 107, 89, 23);
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(132, 141, 89, 23);
		contentPane.add(btnNo);
		
		JLabel lblLookForSaved = new JLabel("Look for saved data and  use it?");
		lblLookForSaved.setBounds(54, 80, 187, 14);
		contentPane.add(lblLookForSaved);
	}

}
