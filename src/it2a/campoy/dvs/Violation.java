package it2a.campoy.dvs;

import java.util.Scanner;

public class Violation {

    public void addViolation() {
        config con = new config();
        Scanner sc = new Scanner(System.in);

        System.out.print("Type of Violation: ");
        String vio = sc.nextLine();

        System.out.print("Payment of Violation: ");
        double pay = sc.nextDouble();
        sc.nextLine();

        System.out.print("Consequences: ");
        String cons = sc.nextLine();

        System.out.print("Duration of Payment: ");
        String dur = sc.nextLine();

        String sqlADD = "INSERT INTO Violations (Violation_Name, Payment, Consequences, Duration) VALUES(?, ?, ?, ?)";
        con.addViol(sqlADD, vio, pay, cons, dur);
    }

    public void viewViolations() {
        String violationQuery = "SELECT * FROM Violations";
        String[] votersHeaders = {"ID", "Violation Name", "Payment", "Consequences", "Duration"};
        String[] votersColumns = {"Violations_ID", "Violation_Name", "Payment", "Consequences", "Duration"};
        config con = new config();
        con.viewViolations(violationQuery, votersHeaders, votersColumns);
    }

    public void mainViolation() {
        Violation vio = new Violation();
        Scanner sc = new Scanner(System.in);
        config con = new config();
        String res;
        int choice;

        do {
           

            System.out.println("=========================================");
            System.out.println("|          VIOLATION MANAGEMENT         |");
            System.out.println("=========================================");
            System.out.println("");
            System.out.println("1. Add Violation");
            System.out.println("2. View Violation");
            System.out.println("3. Update Violation");
            System.out.println("4. Delete Violation");
            System.out.println("5. Exit the Violation Location");
            System.out.println("-----------------------------------------");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    vio.addViolation();
                    break;

                case 2:
                    vio.viewViolations();
                    break;

                case 3:
                    String sql = "UPDATE Violations SET Payment = ?, Consequences = ?, Duration = ? WHERE Violations_ID = ?";
                    vio.viewViolations();

                    int id;
                    while (true) {
                        System.out.print("Enter Violation ID: ");
                        if (sc.hasNextInt()) {
                            id = sc.nextInt();
                            if (con.getSingleValues("SELECT Violations_ID FROM Violations WHERE Violations_ID = ?", id) != 0) {
                                break;
                            } else {
                                System.out.println("Selected Violation doesn't exist.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid numeric Violation ID.");
                            sc.next();
                        }
                    }

                    System.out.print("Enter new Payment: ");
                    String newpay = sc.next();
                    sc.nextLine();
                    System.out.print("Enter new Consequences: ");
                    String newcons = sc.nextLine();
                    System.out.print("Enter new Duration: ");
                    String newdur = sc.nextLine();

                    con.updateViol(sql, newpay, newcons, newdur, id);
                    break;

                case 4:
                    vio.viewViolations();
                    String sqlDELETE = "DELETE FROM Violations WHERE Violations_ID = ?";

                    int id2;
                    while (true) {
                        System.out.print("Enter Violation ID: ");
                        if (sc.hasNextInt()) {
                            id2 = sc.nextInt();
                            if (con.getSingleValues("SELECT Violations_ID FROM Violations WHERE Violations_ID = ?", id2) != 0) {
                                break;
                            } else {
                                System.out.println("Selected Violation doesn't exist.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid numeric Violation ID.");
                            sc.next();
                        }
                    }

                    con.deleteViol(sqlDELETE, id2);
                    break;

                case 5:
                    System.out.println("Exiting....");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

            System.out.println("");
            System.out.print("Do you want to continue? Yes or No: ");
            res = sc.next();

        } while (res.equalsIgnoreCase("yes"));
    }
}
