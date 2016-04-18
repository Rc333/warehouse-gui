

import java.util.*;
import java.text.*;
import java.io.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Clerkstate extends WarehouseState {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Warehouse warehouse;
    private WarehouseContext context;
    private static Clerkstate instance;
    protected boolean CHECKCLIENT = FALSE;

    private static final int ADD_CLIENT = 1;
    private static final int ADD_PRODUCT = 2;
    private static final int PROCESS_ORDER = 3;
    private static final int RECEIVE_SHIPMENT = 4;
    private static final int GET_TRANSACTIONS = 5;
    private static final int SAVE = 8;
    private static final int RECIEVE_PAYMENT = 11;
    private static final int CLIENTMENU = 12;
    private static final int HELP = 13;
    private static final int EXIT = 0;

    private Clerkstate() {
        super();
        warehouse = Warehouse.instance();
        //context = LibContext.instance();
    }

    public static Clerkstate instance() {
        if (instance == null) {
            instance = new Clerkstate();
        }
        return instance;
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
        System.out.println(ADD_CLIENT + " to add a client");
        System.out.println(ADD_PRODUCT + " to  add products");
        System.out.println(PROCESS_ORDER + " to  process order of client");
        System.out.println(RECEIVE_SHIPMENT + " to  receive products shipment");
        System.out.println(GET_TRANSACTIONS + " to  print transactions");

        System.out.println(SAVE + " to  save data");

        System.out.println(RECIEVE_PAYMENT + " to make the payment");

        System.out.println(CLIENTMENU + " to  switch to the client menu");
        System.out.println(HELP + " for help");
    }

    public void addClient() {
        String name = getToken("Enter client name");
        String address = getToken("Enter address");
        String phone = getToken("Enter phone");
        Client result;
        result = warehouse.addClient(name, address, phone);
        if (result == null) {
            System.out.println("Could not add client");
        }
        System.out.println(result);
    }

    public void addProducts() {
        Product result;
        do {
            //String name, String manufacturer, String id, BigDecimal price
            String name = getToken("Enter Product Name");
            String productID = getToken("Enter Product ID");
            String manufacturer = getToken("Enter Manufacturer");
            Double price = Double.parseDouble(getToken("Enter Price"));
            Integer quantity = Integer.parseInt(getToken("Enter the Quantity"));
            result = warehouse.addProduct(name, manufacturer, productID, price, quantity);
            if (result != null && quantity > 0) {
                System.out.println(result);
            } else {
                System.out.println("Product could not be added");
            }
            if (!yesOrNo("Add more products?")) {
                break;
            }
        } while (true);
    }

    public void issueProducts() {

        // ask user ID, call warehouse.testclient to see if it exists, if true, proceeed
        // to issueProduct at Warehouse class
        String clientID = getToken("Enter User ID");
        Client client = warehouse.testClient(clientID);
        if (client == null) {
            System.out.println("No such member");
            return;
        } else {

            do {

                // do while loop here to ask for books. 
                String productID = getToken("Enter Product ID");
                if (warehouse.testProduct(productID) != null) {
                    Integer quantity = Integer.parseInt(getToken("Enter the Quantity"));
                    if (warehouse.issueProduct(client, productID, quantity)) {

                    }

                } else {
                    System.out.println("Product does not exist");
                }

                if (!yesOrNo("Add more products?")) {
                    break;
                }
            } while (true);

        }
    }

    private void receiveShipment() {

        Waititem result;
        do {
            //String name, String manufacturer, String id, BigDecimal price

            String waititemName = getToken("Enter Product name");
            String manufacturerName = getToken("Enter Manufacturer name");
            Integer quantity = Integer.parseInt(getToken("Enter the Quantity"));
            if (warehouse.receiveShipment(manufacturerName, waititemName, quantity)) {

                System.out.println("Shipment Updated");
            } else {
                System.out.println("Product could not be added");
            }
            if (!yesOrNo("Add more products?")) {
                break;
            }
        } while (true);

    }

    private void recievePayment() {
        String clientID = getToken("Enter Client ID");
        Client client = warehouse.makePayment(clientID);
        System.out.println("Client's total Balance is " + client.balance);
        Double price = Double.parseDouble(getToken("How much would client like to pay?"));
        client.balance = client.balance - price;
        System.out.println("Your new balance is " + client.balance);

    }

    public void getTransactions() {
        List allTransactions = warehouse.getTransactions();
        for (Object transactions : allTransactions) {
            System.out.println(transactions);

        }
    }

    private void save() {
        if (warehouse.save()) {
            System.out.println(" The warehouse has been successfully saved in the file WarehouseData \n");
        } else {
            System.out.println(" There has been an error in saving \n");
        }
    }

    public void clientmenu() {
        
        CHECKCLIENT = TRUE;
        
        String clientID = getToken("Please input the client id: ");
        if (ClientList.instance().checkClient(clientID) != null) {
            (WarehouseContext.instance()).setUser(clientID);
            (WarehouseContext.instance()).changeState(2);
        } else {
            System.out.println("Invalid user id.");
        }
    }

    public void logout() {
        CHECKCLIENT = FALSE;
        (WarehouseContext.instance()).changeState(0); // exit with a code 0
    }

    public void process() {
        int command;
        help();
        while ((command = getCommand()) != EXIT) {
            switch (command) {

                case ADD_CLIENT:
                    addClient();
                    break;
                case ADD_PRODUCT:
                    addProducts();
                    break;
                case PROCESS_ORDER:
                    issueProducts();
                    break;
                case RECEIVE_SHIPMENT:
                    receiveShipment();
                    break;
                case SAVE:
                    save();
                    break;
                case RECIEVE_PAYMENT:
                    recievePayment();
                    break;

                case CLIENTMENU:
                    clientmenu();
                    break;
                case HELP:
                    help();
                    break;
            }
        }
        logout();
    }

    public void run() {
        process();
    }
}
