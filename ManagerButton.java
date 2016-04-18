

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;
public class ManagerButton extends JButton implements ActionListener{ 
  private static ManagerButton instance;
  private JButton clientButton, clerkButton, managerButton,  logoutButton;
  private ManagerButton() {
      super("Manager");
  }

  public static ManagerButton instance() {
    if (instance == null) {
      instance = new ManagerButton();
    }
    return instance;
  }

  public void setListener(){
    //System.out.println("In ManagerButton setListener\n");
    this.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
     //System.out.println("In clerk \n");
    (WarehouseContext.instance()).setLogin(WarehouseContext.IsManager);
     Loginstate.instance().clear();
    (WarehouseContext.instance()).changeState(1);
  } 
}