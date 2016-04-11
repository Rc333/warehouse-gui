package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Securitystate {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
	
	
	public String getToken(String prompt) {
	    do {
	      try {
	        System.out.println(prompt);
	        String line = reader.readLine();
	        StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
	        if (tokenizer.hasMoreTokens()) {
	          return tokenizer.nextToken();
	        }
	      } catch (IOException ioe) {
	        System.exit(0);
	      }
	    } while (true);
	  }
	
	
	
	public boolean clerkSecurity(boolean b){
		  String clerkname = getToken("Please input the clerk name: ");
		  String clerkID = getToken("Please input the clerk id: ");
		  if( clerkname.equals("CLERK") && clerkID.equals("CLERK"))
		  {
			
			return true;
	    //(WarehouseContext.instance()).setLogin(WarehouseContext.IsClerk);
	    //(WarehouseContext.instance()).changeState(0);
		  //} 
		  }
		//  else 
			//  System.out.println("invalid id/uname(type both as CLERK)");
		//return null;
		return null != null;
		
			  }
	 
	
	
	public boolean managerSecurity(boolean b){
		  String managername = getToken("Please input the manager name: ");
		  String managerID = getToken("Please input the manager id: ");
		  if( managername.equals("MANAGER") && managerID.equals("MANAGER"))
		  {
			  return true;
		  // (WarehouseContext.instance()).setLogin(WarehouseContext.IsManager);
		    //(WarehouseContext.instance()).changeState(1);
		  }
		//  else 
			//  System.out.println("invalid id/uname(type both as MANAGER)");
		  return null != null;  
	}
		  
		  

	
	
	public boolean clientSecurity(boolean b){
	    String clientID = getToken("Please input the client id: ");
	    if (ClientList.instance().checkClient(clientID) != null){
	    	(WarehouseContext.instance()).setUser(clientID); 
	    }
	      //(WarehouseContext.instance()).setLogin(WarehouseContext.IsClient);
	      //(WarehouseContext.instance()).setUser(clientID);      
	      //(WarehouseContext.instance()).changeState(2);
	    //}
	   // else 
	     // System.out.println("Invalid client id.");
	    return null != null; 
	}



	public boolean clerkSecurityb(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}}
