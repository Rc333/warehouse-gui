package src;

import java.util.*;
import java.io.*;
public class supplierList implements Serializable {
  private static final long serialVersionUID = 1L;
  private List manufacturers = new LinkedList();
  private static supplierList supplierlist;
  private supplierList() {
  }
  public static supplierList instance() {
    if (supplierlist == null) {
      return (supplierlist = new supplierList());
    } else {
      return supplierlist;
    }
  }

  public boolean insertManufacturer(Manufacturer manufacturer) {
    manufacturers.add(manufacturer);
    return true;
  }

  public Iterator getManufacturers(){
     return manufacturers.iterator();
  }
  
  private void writeObject(java.io.ObjectOutputStream output) {
    try {
      output.defaultWriteObject();
      output.writeObject(supplierlist);
    } catch(IOException ioe) {
      ioe.printStackTrace();
    }
  }
  private void readObject(java.io.ObjectInputStream input) {
    try {
      if (supplierlist != null) {
        return;
      } else {
        input.defaultReadObject();
        if (supplierlist == null) {
          supplierlist = (supplierList) input.readObject();
        } else {
          input.readObject();
        }
      }
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } catch(ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
  }
  public String toString() {
    return manufacturers.toString();
  }
  
 

  
  
}
