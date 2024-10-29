
package it2a.campoy.dvs;

import java.util.Scanner;


public class Driver {
    
    
    public void addDriver(){
        
         config con = new config();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter First name: ");
        String fname = sc.next();
        System.out.print("Enter Last name: ");
        String lname = sc.next();
        System.out.print("Enter address: ");
        String address = sc.next();
        System.out.print("Enter Status: ");
        String status = sc.next();
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        String sql = "INSERT INTO DViolation (f_name, l_name, Address, status, age) VALUES (?, ?, ?, ?, ?)";
        
       con.addViol(sql, fname, lname, address, status, age);
        
        
    }
    
    public void viewDriver(){
         String votersQuery = "SELECT * FROM DViolation";
        String[] votersHeaders = {"ID","Firstname", "Lastname", "Address", "Status", "age"};
        String[] votersColumns = {"ID","f_name", "l_name", "address", "status", "age"};
        config con = new config();
        con.viewViolations(votersQuery, votersHeaders, votersColumns);
    }
    
    public void mainDriver(){
        Driver dr = new Driver();
        
        Scanner sc = new Scanner(System.in);

        config con = new config();
        
    
        
        String res;
        int choice;
        
         do {
        System.out.println(" -- DRIVER LOCATION -- ");
        System.out.println("1. ADD DRIVER");
        System.out.println("2. VIEW DRIVER");
        System.out.println("3. UPDATE DRIVER");
        System.out.println("4. DELETE DRIVER");
        System.out.println("5. EXIT THE APPLICATION");
        
        System.out.print("Enter choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                dr.addDriver();
                break;

            case 2: 
                dr.viewDriver();
                break;

            case 3:
                
                String sql = "UPDATE DViolation SET Address = ? , age = ?, status = ? WHERE ID = ?";
                dr.viewDriver();
              
              
               System.out.print("Enter License ID of the violation to update: ");
               int id = sc.nextInt();
            
           
                System.out.print("Enter new Address: ");
                String newadd = sc.next();
                System.out.print("Enter new Status: ");
                String newstats = sc.next();
                System.out.print("Enter new Age: ");
                int age = sc.nextInt();
                con.updateViol(sql,newadd, newstats, age,id);

                 break;
             
             
            case 4:

                    dr.viewDriver();
                   String sqlDELETE = "DELETE FROM DViolation WHERE ID = ?";

                   System.out.print("Enter Driver ID to delete: ");
                   int id2 = sc.nextInt();

                   con.deleteViol(sqlDELETE, id2);

                   break;
                
                
            case 5:
                
                System.out.println("Exiting....");
             break;
             
             
        }
                System.out.print("Do you want to continue? Yes or No: ");
                res = sc.next();
             
    }while (res.equalsIgnoreCase("yes"));
    
     
       
    }
}
