
import java.util.*;
import java.text.*;
import java.io.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
public class Managerstate extends WarehouseState {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Warehouse Warehouse;
//  protected Boolean IsManager = TRUE; //added logic
  private WarehouseContext context;
  private static Managerstate instance;
  private static final int EXIT = 0;
  private static final int ADD_MANUFACTURER = 12;
  private static final int SHOW_CLIENTS = 6;
  private static final int SHOW_PRODUCTS = 7;
  private static final int SHOW_INVOICES = 9;
  private static final int SHOW_WAITLIST = 10;
  
  private static final int CLERKMENU = 11;
  private static final int HELP = 13;
  protected boolean CHECKMANAGER = FALSE;
  private Managerstate() {
      super();
      Warehouse = Warehouse.instance();
     // context = WarehouseContext.instance();
  }

  public static Managerstate instance() {
    if (instance == null) {
      instance = new Managerstate();
    }
    return instance;
  }

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
  private boolean yesOrNo(String prompt) {
    String more = getToken(prompt + " (Y|y)[es] or anything else for no");
    if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
      return false;
    }
    return true;
  }
  public int getNumber(String prompt) {
    do {
      try {
        String item = getToken(prompt);
        Integer num = Integer.valueOf(item);
        return num.intValue();
      } catch (NumberFormatException nfe) {
        System.out.println("Please input a number ");
      }
    } while (true);
  }
  public Calendar getDate(String prompt) {
    do {
      try {
        Calendar date = new GregorianCalendar();
        String item = getToken(prompt);
        DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
        date.setTime(df.parse(item));
        return date;
      } catch (Exception fe) {
        System.out.println("Please input a date as mm/dd/yy");
      }
    } while (true);
  }
  public int getCommand() {
    do {
      try {
        int value = Integer.parseInt(getToken("Enter command:" + HELP + " for help"));
        if (value >= EXIT && value <= HELP) {
          return value;
        }
      } catch (NumberFormatException nfe) {
        System.out.println("Enter a number");
      }
    } while (true);
  }

  public void help() {
    System.out.println("Enter a number between 0 and 12 as explained below:");
    System.out.println(EXIT + " to Exit\n");
    
    System.out.println(SHOW_CLIENTS + " to  print clients");
    System.out.println(SHOW_PRODUCTS + " to  print products");
    System.out.println(SHOW_INVOICES + " to view invoices");
    System.out.println(SHOW_WAITLIST + " to view items in waitList");
    System.out.println(ADD_MANUFACTURER + " to add a manufacturer");
    System.out.println(CLERKMENU + " to  switch to the clerk menu");
    System.out.println(HELP + " for help");
  }
  
  public void showProducts() {
      Iterator allProducts = Warehouse.getProducts();
      while (allProducts.hasNext()) {
          Product product = (Product) (allProducts.next());
          System.out.println(product.toString());
      }
  }

  public void showClients() {
      Iterator allClients = Warehouse.getClients();
      while (allClients.hasNext()) {
          Client client = (Client) (allClients.next());
          System.out.println(client.toString());
      }
  }
  
  public void showInvoices() {
      String clientID = getToken("Enter Client ID");
      System.out.println(Warehouse.showInvoices(clientID));
      Client client = Warehouse.testClient(clientID);
      System.out.println("The Client's balance is "+ client.balance);

  }

  public void showWaitList() {
      Iterator allProducts = Warehouse.getWaitlist();
      while (allProducts.hasNext()) {
          Waititem product = (Waititem) (allProducts.next());
          System.out.println(product.toString());
      }
  }
  
  public void addManufacturer() {
      String name = getToken("Enter manufacturer name");
      String id = getToken("Enter manufacturerID");
      Manufacturer result;
      result = Warehouse.addManufacturer(name, id);
      if (result == null) {
          System.out.println("Could not add manufacturer");
      }
      System.out.println(result);

  }

 

  public void clerkmenu()
  {
	  System.out.println(" you are transferred into clerk menu:");
   /* String clientID = getToken("you ");
    if (ClientList.instance().checkClient(clientID) != null){
      (WarehouseContext.instance()).setUser(clientID);*/ 
      CHECKMANAGER = TRUE;
      (WarehouseContext.instance()).changeState(0);
    }
 //   else 
   //   System.out.println("Invalid user id."); 
  //}

  public void logout()
  {
      CHECKMANAGER = FALSE;
    (WarehouseContext.instance()).changeState(3); // exit with a code 0
  }
 

  public void process() {
    int command;
    help();
    while ((command = getCommand()) != EXIT) {
      switch (command) {
      
      case SHOW_CLIENTS:
          showClients();
          break;
      case SHOW_PRODUCTS:
          showProducts();
          break;
      case SHOW_INVOICES:
          showInvoices();
          break;
      case SHOW_WAITLIST:
          showWaitList();
          break;
      
      
        case CLERKMENU:          clerkmenu();
                                break;
        case HELP:              help();
                                break;
      }
    }
    logout();
  }
  public void run() {
    process();
  }
}

