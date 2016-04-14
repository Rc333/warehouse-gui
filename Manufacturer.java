package src;

import java.util.*;
import java.io.*;

public class Manufacturer implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String id;
    
   
   
    public Manufacturer(String name, String id) {
        this.name = name;
        this.id = id;
       
       
    }

    public String getName() {
        return name;
    }

    public String getid() {
        return id;
    }

   

    public void setName(String newName) {
        name = newName;
    }

    public void setid(String newid) {
        id = newid;
    }

   

    public String toString() {
        String string = "manufacturer name " + name + " id " + id;
        return string;
    }

}