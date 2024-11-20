package it2a.campoy.dvs;

import java.util.Scanner;

public class Driver {

    public void addDriver() {
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

    public void viewDriver() {
        String votersQuery = "SELECT * FROM DViolation";
        String[] votersHeaders = {"ID", "Firstname", "Lastname", "Address", "Status", "Age"};
        String[] votersColumns = {"ID", "f_name", "l_name", "address", "status", "age"};
        config con = new config();
        con.viewViolations(votersQuery, votersHeaders, votersColumns);
    }

    public void mainDriver() {
        Scanner sc = new Scanner(System.in);
        config con = new config();
        String res;
        int choice;

        do {
          

            System.out.println("=========================================");
            System.out.println("|            DRIVER MANAGEMENT          |");
            System.out.println("=========================================");
            System.out.println("");
            System.out.println("1. Add Driver");
            System.out.println("2. View Driver");
            System.out.println("3. Update Driver");
            System.out.println("4. Delete Driver");
            System.out.println("5. Exit Application");
            System.out.println("-----------------------------------------");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addDriver();
                    break;

                case 2:
                    viewDriver();
                    break;

                case 3:
                    String sql = "UPDATE DViolation SET Address = ?, age = ?, status = ? WHERE ID = ?";
                    viewDriver();

                    int ID;
                    while (true) {
                        System.out.print("Enter DViolation ID: ");
                        if (sc.hasNextInt()) {
                            ID = sc.nextInt();
                            if (con.getSingleValues("SELECT ID FROM DViolation WHERE ID = ?", ID) != 0) {
                                break;
                            } else {
                                System.out.println("Selected Driver doesn't exist.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid numeric Driver ID.");
                            sc.next();
                        }
                    }

                    System.out.print("Enter new Address: ");
                    String newadd = sc.next();
                    System.out.print("Enter new Status: ");
                    String newstats = sc.next();
                    System.out.print("Enter new Age: ");
                    int age = sc.nextInt();
                    con.updateViol(sql, newadd, newstats, age, ID);
                    break;

                case 4:
                    viewDriver();
                    String sqlDELETE = "DELETE FROM DViolation WHERE ID = ?";

                    int idDel;
                    while (true) {
                        System.out.print("Enter Driver ID: ");
                        if (sc.hasNextInt()) {
                            idDel = sc.nextInt();
                            if (con.getSingleValues("SELECT ID FROM DViolation WHERE ID = ?", idDel) != 0) {
                                break;
                            } else {
                                System.out.println("Selected Driver doesn't exist.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid numeric Violation Driver ID.");
                            sc.next();
                        }
                    }
                    con.deleteViol(sqlDELETE, idDel);
                    break;

                case 5:
                    System.out.println("Exiting....");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

            System.out.print("Do you want to continue? Yes or No: ");
            res = sc.next();

        } while (res.equalsIgnoreCase("yes"));
    }
}
