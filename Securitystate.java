
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.StringTokenizer;

public class Securitystate {

    private static Warehouse warehouse;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getToken(String prompt) {
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

    public static boolean clerkSecurity(boolean b) {
        //   Securitystate sc = new Securitystate();
        String clerkname = getToken("Please input the clerk name: ");
        String clerkID = getToken("Please input the clerk id: ");
        if (clerkname.equals("CLERK") && clerkID.equals("CLERK")) {

            return (true);
	    //(WarehouseContext.instance()).setLogin(WarehouseContext.IsClerk);
            //(WarehouseContext.instance()).changeState(0);
            //} 
        } else {
            System.out.println("invalid id/uname(type both as CLERK)");
        }

        return (false);
		//return null;
        //return null != null;

    }

    public static boolean managerSecurity(boolean b) {
        // Securitystate sc = new Securitystate();
        String managername = getToken("Please input the manager name: ");
        String managerID = getToken("Please input the manager id: ");
        if (managername.equals("MANAGER") && managerID.equals("MANAGER")) {
            return true;
		  // (WarehouseContext.instance()).setLogin(WarehouseContext.IsManager);
            //(WarehouseContext.instance()).changeState(1);
        } else {
            System.out.println("invalid id/uname(type both as MANAGER)");
        }
        return (false);
    }

    public static boolean clientSecurity(boolean b) {
		// Securitystate sc = new Securitystate();

        //
        warehouse = Warehouse.instance();
        String clientID = getToken("Enter User ID/n");
        try {
        Client client = warehouse.testClient(clientID);
        if (client == null) {
            //System.out.println("No such member");
            return FALSE;
        } else {
            //System.out.println("Login Succesful from Security State");
            return TRUE;
            
        }    
        } catch (Exception e) {
            //System.out.println("Login falied from Security State");
            return FALSE;
        }
        

    }

    public boolean clerkSecurityb(boolean b) {
        // TODO Auto-generated method stub
        return false;
    }
}
