package src;
import javax.swing.*;

import java.util.*;
import java.text.*;
import java.io.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loginstate extends WarehouseState implements ActionListener {

    private static final int CLERK_LOGIN = 0;
    private static final int MANAGER_LOGIN = 1;
    private static final int CLIENT_LOGIN = 2;
    private static final int EXIT = 3;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private WarehouseContext context;
    private JFrame frame;
    private static Loginstate instance;
    private AbstractButton clientButton, clerkButton, managerButton, logoutButton;

    private Loginstate() {
        super();
        // context = LibContext.instance();
        clientButton = new JButton("client");
        clientButton.addActionListener(this);
        
        
        logoutButton = new JButton("logout");
        logoutButton.addActionListener(this);
        
        clerkButton = ClerkButton.instance();
        ClerkButton.instance().setListener();
       
        
      
        managerButton = ManagerButton.instance();
        ManagerButton.instance().setListener();  
    }

    public static Loginstate instance() {
        if (instance == null) {
            instance = new Loginstate();
        }
        return instance;
    }
    
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(this.clientButton)) 
           {//System.out.println("user \n"); 
             this.client();}
        else if (event.getSource().equals(this.logoutButton)) 
           (WarehouseContext.instance()).changeState(3);
      } 
    
    public void clear() { //clean up stuff
        frame.getContentPane().removeAll();
        frame.paint(frame.getGraphics());   
      }  


    public int getCommand() {
        do {
            try {
                int value = Integer.parseInt(getToken("Enter command:"));
                if (value <= EXIT && value >= CLERK_LOGIN) {
                    return value;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Enter a number");
            }
        } while (true);
    }

    public String getToken(String prompt) {
        do {
            try {
                System.out.println(prompt);
                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
                if (tokenizer.hasMoreTokens()) {
                    return tokenizer.nextToken();
                }
            } catch (IOException ioe) {
                System.exit(0);
            }
        } while (true);
    }

    private boolean yesOrNo(String prompt) {
        String more = getToken(prompt + " (Y|y)[es] or anything else for no");
        if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
            return false;
        }
        return true;
    }

    private void clerk() {

        Securitystate securitystate;
        securitystate = new Securitystate();
        int clear;
//	Securitystate sc = new Securitystate();
        if (Securitystate.clerkSecurity(true)) {
		//  Loginstate clerk;
            //if (Securitystate.clerkSecurity(clerk))

            // String clerkname = getToken("Please input the clerk name: ");
            //String clerkID = getToken("Please input the clerk id: ");
            // if( clerkname.equals("CLERK") && clerkID.equals("CLERK"))
            //{
            (WarehouseContext.instance()).setLogin(WarehouseContext.IsClerk);
            (WarehouseContext.instance()).changeState(0);
        }
        if (false) {
            System.out.println("invalid id/uname(type both as CLERK)");
        }

    }

    private void manager() {

        Securitystate securitystate;
        securitystate = new Securitystate();
        int clear;
//Securitystate sc = new Securitystate();
        if (Securitystate.managerSecurity(true)) {
            //  Loginstate clerk;
            //if (Securitystate.clerkSecurity(clerk))

// String clerkname = getToken("Please input the clerk name: ");
//String clerkID = getToken("Please input the clerk id: ");
// if( clerkname.equals("CLERK") && clerkID.equals("CLERK"))
//{
            (WarehouseContext.instance()).setLogin(WarehouseContext.IsManager);
            (WarehouseContext.instance()).changeState(1);
        }
        if (false) {
            System.out.println("invalid id/uname(type both as CLERK)");
        }

    }

    private void client() {
       /* Securitystate securitystate;
        securitystate = new Securitystate();
        int clear;
        String clientID = null;
        Securitystate sc = new Securitystate();

        //
        //
        if (securitystate.clientSecurity(TRUE)) {
            //System.out.println("From login state true");
            //  String clientID = getToken("Please input the client id: ");
            //if (ClientList.instance().checkClient(clientID) != null){
            (WarehouseContext.instance()).setLogin(WarehouseContext.IsClient);
            (WarehouseContext.instance()).setUser(clientID);
            (WarehouseContext.instance()).changeState(2);
        } else {
            System.out.println("Invalid client id./n");
        }*/
    	String clientID = JOptionPane.showInputDialog(frame,"Please input the user id: ");
   if( Warehouse.instance().testClient(clientID) != null){
 (WarehouseContext.instance()).setLogin(WarehouseContext.IsClient);
 (WarehouseContext.instance()).setUser(clientID);  
  clear();
 (WarehouseContext.instance()).changeState(2);
}
else 
 JOptionPane.showMessageDialog(frame,"Invalid user id.");
    	
    	
    }

    public void process() {
        int command;
        System.out.println("Please input 0 to login as Clerk\n"
                + "input 1 to login as manager\n"
                + "input 2 to login as client\n"
                + "input 3 to exit the system\n");
        while ((command = getCommand()) != EXIT) {

            switch (command) {
                case CLERK_LOGIN:
                    clerk();
                    break;
                case MANAGER_LOGIN:
                    manager();
                    break;
                case CLIENT_LOGIN:
                    client();
                    break;
                default:
                    System.out.println("Invalid choice");

            }
            System.out.println("Please input 0 to login as Clerk\n"
                    + "input 1 to login as manager\n"
                    + "input 2 to login as client\n"
                    + "input 3 to exit the system\n");
        }
        (WarehouseContext.instance()).changeState(3);
    }

    public void run() {
        frame = WarehouseContext.instance().getFrame();
        frame.getContentPane().removeAll();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(this.clientButton);
        frame.getContentPane().add(this.clerkButton);
        frame.getContentPane().add(this.managerButton);
        frame.getContentPane().add(this.logoutButton);
        frame.setVisible(true);
        frame.paint(frame.getGraphics()); 
    }
}
