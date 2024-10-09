
package it2a.campoy.dvs;

import java.util.Scanner;

public class IT2ACAMPOYDVS {

    public void addViol() {
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
        System.out.print("Enter License id: ");
        String license = sc.next();

        String sql = "INSERT INTO DViolation (f_name, l_name, Address, status, License_id) VALUES (?, ?, ?, ?, ?)";
        con.addViol(sql, fname, lname, address, status, license);
    }
    
    
public void viewViolations() {
        String votersQuery = "SELECT * FROM DViolation";
        String[] votersHeaders = {"Firstname", "Lastname", "Address", "Status", "License id"};
        String[] votersColumns = {"f_name", "l_name", "address", "status", "License_id"};
        config con = new config();
        con.viewViolations(votersQuery, votersHeaders, votersColumns);
    }

   private void updateViol() {
    config con = new config();
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter License ID of the violation to update: ");
    String license = sc.next();
    System.out.print("Enter new First Name: ");
    String newfname = sc.next();
    System.out.print("Enter new Last Name: ");
    String newlname = sc.next();
    System.out.print("Enter new Address: ");
    String newadd = sc.next();
    System.out.print("Enter new Status: ");
    String newstats = sc.next();

    con.updateViol(license, newfname, newlname, newadd, newstats);
}

    private void deleteViol() {
        config con = new config();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter License ID of the violation to delete: ");
        String license = sc.next();

        String sql = "DELETE FROM DViolation WHERE License_id = ?";
        con.deleteViol(sql, license);
    }

    public static void main(String[] args) {
        IT2ACAMPOYDVS dvs = new IT2ACAMPOYDVS();
        config con = new config();
        Scanner sc = new Scanner(System.in);
String resp;
        int choice;
         do {
        System.out.println(" -- DRIVING VIOLATION -- ");
        System.out.println("1. ADD ");
        System.out.println("2. VIEW ");
        System.out.println("3. UPDATE ");
        System.out.println("4. DELETE ");
        
        System.out.print("Enter choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                dvs.addViol();
                break;

            case 2: 
                dvs.viewViolations();
                break;

            case 3:
                dvs.updateViol();
                break;

            case 4:
                dvs.deleteViol();
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
             System.out.print("Continue? ");
             resp = sc.next();
    }while (resp.equalsIgnoreCase("yes"));
         System.out.println("Thankyou");
}
}