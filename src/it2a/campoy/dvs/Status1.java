
package it2a.campoy.dvs;

import java.util.Scanner;


public class Status1 {
    
    public  void Status(){
        
        
         config con = new config();
         Scanner sc = new Scanner(System.in);
          String res;
         do{
          System.out.print("\033[H\033[2J");
            System.out.flush();
            
            System.out.println("=====================================");
            System.out.println("|           STATUS MENU            |");
            System.out.println("=====================================");
            System.out.println("1. Edit Status");
            System.out.println("2. View Status");
            System.out.println("3. Log Out");
            System.out.println("=====================================");

          System.out.print("Enter Choice: ");
          int choice = sc.nextInt();
          
          switch(choice){
              case 1:
                  
                 Driver dr = new Driver();
                 dr.viewDriver();
                 Violation vio  = new Violation();
                 vio.viewViolations();
                 ViolationRecords vr = new ViolationRecords();
                 vr.viewViolationRecords();
                  
                 
                 String sqlUPDATE = "UPDATE ViolationRecords SET Status = ? WHERE Driver_ID = ? AND Violation_ID = ? ";
                  
                 int id3;
                while (true) {
                System.out.print("Enter Driver ID: ");
                if (sc.hasNextInt()) {
                    id3 = sc.nextInt();
                    if (con.getSingleValues("SELECT Driver_ID FROM ViolationRecords WHERE Driver_ID = ?", id3) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Driver doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Driver ID.");
                    sc.next(); 
                }
            }
                  
                    int id4;
                while (true) {
                System.out.print("Enter Violation ID: ");
                if (sc.hasNextInt()) {
                    id4 = sc.nextInt();
                    sc.nextLine();
                    if (con.getSingleValues("SELECT Violation_ID FROM ViolationRecords WHERE Violation_ID = ?", id4) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Violation doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid numeric Violation ID.");
                    sc.next(); 
                }
            }                 
                System.out.print("Enter Status: ");
                  String stats = sc.nextLine();
                  con.updateViol(sqlUPDATE, stats, id3, id4);
                 
                 
                  break;
              case 2:
                  
                  vr  = new ViolationRecords();
                  vr.viewViolationRecords();
                  break;
              
              case 3: 
                  
                  
                  System.out.println("Exitinggggg....");
                  break;
              
              
              
          }
          
             System.out.print("Do you want to continue on Status Class? Yes or No: ");
             res = sc.next();
         }while(res.equalsIgnoreCase("yes"));
          
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
