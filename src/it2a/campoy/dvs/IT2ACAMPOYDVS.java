
package it2a.campoy.dvs;

import java.util.Scanner;


public class IT2ACAMPOYDVS {

   
   public void addviol() {
       config con = new config();
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter First name: ");
        String fname = sc.next();
        System.out.println("Enter Last name: ");
        String lname = sc.next();
        System.out.println("Enter address: ");
        String address =  sc.next();
        System.out.println("Enter Status: ");
        String status = sc.next();
        System.out.println("Enter violation: ");
        String viol = sc.next();
        String sql = "INSERT INTO DViolation (f_name, l_name, Address, status,violation) VALUES (?, ?, ?, ?, ?)";
        con.addViol(sql, fname, lname,address, status,viol);
    }
     public static void main(String[] args) {
         IT2ACAMPOYDVS dvs = new IT2ACAMPOYDVS();
          config con = new config();
           Scanner sc = new Scanner(System.in);
            
           int choice; 
           
         System.out.println(" -- DRIVING VIOLATION -- ");
         System.out.println(" --ADD VIOLATION-- ");
         System.out.println(" -- VIEW VIOLATION-- ");
         
         System.out.println("Enter choice: ");
         choice = sc.nextInt();

     switch (choice){
             case 1:
            dvs.addviol();
             break;
             
             case 2: 
                 con.viewViolations();
     }
}
}