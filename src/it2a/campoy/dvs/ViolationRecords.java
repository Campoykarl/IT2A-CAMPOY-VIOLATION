package it2a.campoy.dvs;

import java.util.Scanner;

public class ViolationRecords {

    public void addRecords() {
        config con = new config();
        Scanner sc = new Scanner(System.in);

        System.out.println(" - SELECT A DRIVER - ");
        Driver dr = new Driver();
        dr.viewDriver();

        System.out.println(" - SELECT A VIOLATION - ");
        Violation vio = new Violation();
        vio.viewViolations();

        int ID;
        while (true) {
            System.out.print("Enter Driver ID: ");
            if (sc.hasNextInt()) {
                ID = sc.nextInt();
                if (con.getSingleValues("SELECT Driver_ID FROM ViolationRecords WHERE Driver_ID = ?", ID) != 0) {
                    break;
                } else {
                    System.out.println("Selected Driver doesn't exist.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid numeric Driver ID.");
                sc.next();
            }
        }

        int ID2;
        while (true) {
            System.out.print("Enter Violation ID: ");
            if (sc.hasNextInt()) {
                ID2 = sc.nextInt();
                if (con.getSingleValues("SELECT Violations_ID FROM Violations WHERE Violations_ID = ?", ID2) != 0) {
                    break;
                } else {
                    System.out.println("Selected Violation doesn't exist.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid numeric Violation ID.");
                sc.next();
            }
        }

        System.out.print("Date of Violate: ");
        String date = sc.next();
        System.out.print("License Plate: ");
        String lic = sc.next();
        System.out.print("Payment: ");
        double pay = sc.nextDouble();

        String sqlAdd = "INSERT INTO ViolationRecords (Driver_ID, Violation_ID, Date_Of_Violate, License_Plate, Payment) VALUES (?, ?, ?, ?, ?)";
        con.addViol(sqlAdd, ID, ID2, date, lic, pay);
    }

    public void viewVRecords() {
        config con = new config();

        String violationRecordsQuery = 
            "SELECT vr.Driver_ID, vr.Violation_ID, vr.Date_Of_Violate, vr.License_Plate, vr.Payment, " +
            "d.f_name AS Driver_Firstname, d.l_name AS Driver_Lastname, " +
            "v.Violation_Name " +
            "FROM ViolationRecords vr " +
            "INNER JOIN DViolation d ON vr.Driver_ID = d.ID " +
            "INNER JOIN Violations v ON vr.Violation_ID = v.Violations_ID";

        String[] headers = {"Driver ID", "Violation ID", "Date of Violate", "License Plate", "Payment", "Driver Firstname", "Driver Lastname", "Violation Name"};
        String[] columns = {"Driver_ID", "Violation_ID", "Date_Of_Violate", "License_Plate", "Payment", "Driver_Firstname", "Driver_Lastname", "Violation_Name"};

        con.viewViolations(violationRecordsQuery, headers, columns);
    }

    public void viewViolationRecords() {
        config con = new config();

        String view = "SELECT * FROM ViolationRecords";
        System.out.println("   VIOLATION RECORD LIST: ");
        String[] vrHeader = {"Violation Records ID", "Driver ID", "Violation ID", "Date of Violate", "License Plate", "Payment", "Status"};
        String[] vrColumn = {"ViolationRecords_ID", "Driver_ID", "Violation_ID", "Date_Of_Violate", "License_Plate", "Payment", "Status"};

        con.viewViolations(view, vrHeader, vrColumn);
    }

    public void mainVR() {
        config con = new config();
        Scanner sc = new Scanner(System.in);
        ViolationRecords vr = new ViolationRecords();
        String res;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("=========================================");
            System.out.println("|         VIOLATION RECORDS            |");
            System.out.println("=========================================");
            System.out.println("1. Add a Record");
            System.out.println("2. View Records");
            System.out.println("3. Update Records");
            System.out.println("4. Delete Records");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    vr.addRecords();
                    break;

                case 2:
                    vr.viewViolationRecords();
                    vr.viewVRecords();
                    break;

                case 3:
                    vr.viewVRecords();
                    String sqlUPDATE = "UPDATE ViolationRecords SET Date_Of_Violate = ?, License_Plate = ?, Payment = ? WHERE Driver_ID = ? AND Violation_ID = ?";

                    int ID;
                    while (true) {
                        System.out.print("Enter Driver ID: ");
                        if (sc.hasNextInt()) {
                            ID = sc.nextInt();
                            if (con.getSingleValues("SELECT Driver_ID FROM ViolationRecords WHERE Driver_ID = ?", ID) != 0) {
                                break;
                            } else {
                                System.out.println("Selected Driver doesn't exist.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid numeric Driver ID.");
                            sc.next();
                        }
                    }

                    int ID2;
                    while (true) {
                        System.out.print("Enter Violation ID: ");
                        if (sc.hasNextInt()) {
                            ID2 = sc.nextInt();
                            if (con.getSingleValues("SELECT Violation_ID FROM ViolationRecords WHERE Violation_ID = ?", ID2) != 0) {
                                break;
                            } else {
                                System.out.println("Selected Violation doesn't exist.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid numeric Violation ID.");
                            sc.next();
                        }
                    }

                    System.out.print("Enter new Date of Violate: ");
                    String newDate = sc.next();
                    System.out.print("Enter new License Plate: ");
                    String newlic = sc.next();
                    System.out.print("Enter new Payment: ");
                    double newpay = sc.nextDouble();

                    con.updateViol(sqlUPDATE, newDate, newlic, newpay, ID, ID2);
                    break;

                case 4:
                    vr.viewViolationRecords();

                    String sqlDELETE = "DELETE FROM ViolationRecords WHERE ViolationRecords_ID = ?";
                    int idUp;
                    while (true) {
                        System.out.print("Enter Violation Records ID: ");
                        if (sc.hasNextInt()) {
                            idUp = sc.nextInt();
                            if (con.getSingleValues("SELECT ViolationRecords_ID FROM ViolationRecords WHERE ViolationRecords_ID = ?", idUp) != 0) {
                                break;
                            } else {
                                System.out.println("Selected Violation Records doesn't exist.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid numeric Violation Records ID.");
                            sc.next();
                        }
                    }

                    con.deleteViol(sqlDELETE, idUp);
                    break;

                case 5:
                    System.out.println("Exiting....");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

            System.out.println("");
            System.out.print("Do you want to continue on Violation Records? Yes or No: ");
            res = sc.next();

        } while (res.equalsIgnoreCase("yes"));
    }
}
