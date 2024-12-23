package it2a.campoy.dvs;

import static java.lang.System.exit;
import java.util.Scanner;

public class IT2ACAMPOYDVS {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int choice;
        String response;
        boolean exit  = true;
        do {
           
            System.out.println("");
            System.out.println("|         VIOLATION MANAGEMENT          |");
         
            System.out.println("");
            System.out.println("          Please select an option:       ");
            System.out.println("-----------------------------------------");
            System.out.println("    1. Driver");
            System.out.println("    2. Violation");
            System.out.println("    3. Violation Records");
            System.out.println("    4. Update Status of Records");
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
                     Status1 sts = new Status1();
                     sts.Status();    
                    break;

                case 5:
                    System.out.println("Are you sure you want  to exit? Yes or No: ");
                    String res = sc.next();
                    if(res.equalsIgnoreCase("yes")){
                        exit = false;
                    }
                    break;
            }
        } while (exit);

        System.out.println("Thank You!");
        sc.close(); 
    }
}
