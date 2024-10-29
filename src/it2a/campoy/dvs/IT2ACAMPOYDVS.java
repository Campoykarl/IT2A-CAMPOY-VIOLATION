
package it2a.campoy.dvs;

import java.util.Scanner;

public class IT2ACAMPOYDVS {

    public static void main(String[] args) {
        
        
        IT2ACAMPOYDVS dvs = new IT2ACAMPOYDVS();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1. Driver");
        
        
        int choice;
        boolean exit = true;
        System.out.print("Enter choice: ");
        choice  = sc.nextInt();
        
        do{
        switch(choice){
            
            case 1: 
                Driver dr = new Driver();
                dr.mainDriver();
                
                break;
            case 5:
                  System.out.println("Are you sure you want to exit? Yes or No: ");
                String response = sc.next();
                
                if(response.equalsIgnoreCase("yes")){
                    exit = false;
                }
        }
                break;
        }while(exit);
            System.out.println("Thank You ! ");
        
        }
        }