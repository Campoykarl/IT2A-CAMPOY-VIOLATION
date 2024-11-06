
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
                
                 ViolationRecords vr = new ViolationRecords();
                 vr.viewVRecords();
                  
                 
                 String sqlUPDATE = "UPDATE ViolationRecords SET Status = ? WHERE ViolationRecords_ID = ? ";
                  
                 int id3;
                while (true) {
                System.out.print("Enter Violation Records: ");
                if (sc.hasNextInt()) {
                    id3 = sc.nextInt();
                    if (con.getSingleValues("SELECT ViolationRecords_ID FROM ViolationRecords WHERE ViolationRecords_ID = ?", id3) != 0) {
                        break;
                    } else {
                        System.out.println("Selected Violation Records doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid Violation Recordsr ID.");
                    sc.next(); 
                }
            }
                  
                    
                System.out.print("Enter Status: ");
                  String stats = sc.next();
                  con.updateViol(sqlUPDATE, stats, id3);
                 
                 
                  break;
              case 2:
                  
                  vr  = new ViolationRecords();
                 vr.viewVRecords();
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
