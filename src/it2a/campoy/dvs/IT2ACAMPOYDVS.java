package it2a.campoy.dvs;

import static java.lang.System.exit;
import java.util.Scanner;

public class IT2ACAMPOYDVS {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int choice;
        String response;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("=========================================");
            System.out.println("|         VIOLATION MANAGEMENT          |");
            System.out.println("=========================================");
            System.out.println("");
            System.out.println("          Please select an option:       ");
            System.out.println("-----------------------------------------");
            System.out.println("    1. Driver");
            System.out.println("    2. Violation");
            System.out.println("    3. Violation Records");
            System.out.println("    4. Staff Only");
            System.out.println("    5. Exit the Application ");
            System.out.println("-----------------------------------------");
            System.out.println("");
            System.out.println("");

            while (true) {
                System.out.print("Enter choice: ");
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    if (choice >= 1 && choice <= 5) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and 5.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next();
                }
            }

            switch (choice) {
                case 1:
                    Driver dr = new Driver();
                    dr.mainDriver();
                    break;

                case 2:
                    Violation vio = new Violation();
                    vio.mainViolation();
                    break;

                case 3:
                    ViolationRecords vr = new ViolationRecords();
                    vr.mainVR();
                    break;

                case 4:
                    System.out.print("Are you a Staff? Yes or No: ");
                    String res = sc.next();

                    if (res.equalsIgnoreCase("yes")) {
                        System.out.print("Enter Staff password: ");
                        String hrPassword = sc.next();

                        final String STAFF_PASSWORD = "karlpogi";

                        if (hrPassword.equals(STAFF_PASSWORD)) {
                            Status1 sts = new Status1();
                            sts.Status();
                        } else {
                            System.out.println("Invalid Staff password. Access denied.");
                        }
                    } else {
                        System.out.println("You do not have permission to access Staff-only features.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the application...");
                    exit(0);
                    break;
            }

            System.out.print("Do you want to continue to the main menu? Yes or No: ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));

        System.out.println("Thank You!");
        sc.close(); 
    }
}
