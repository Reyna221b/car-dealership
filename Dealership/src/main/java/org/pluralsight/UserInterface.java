package org.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface
{
    static final Scanner userInput = new Scanner(System.in);
    public Dealership dealership;
    public DealershipFileManager fileManager;

    public int display(){
        init();
        while (true){
            try{
                System.out.println(Colors.CYAN);
                System.out.println("\t\tHome Screen");
                System.out.println("-".repeat(30));
                System.out.println("Find Vehicles by: ");
                System.out.println("[1] - Price Range");
                System.out.println("[2] - Make/Model");
                System.out.println("[3] - Year");
                System.out.println("[4] - Color");
                System.out.println("[5] - Mileage Range");
                System.out.println("[6] - Type(car, suv, truck, van)");
                System.out.println("[7] - List All Vehicles");
                System.out.println("[8] - Add a vehicle");
                System.out.println("[9] - Remove a Vehicle");
                System.out.println(Colors.RED + "[99] - Quit"+ Colors.RESET);
                System.out.println(Colors.CYAN+ "-".repeat(30));
                System.out.print(Colors.RESET);
                System.out.print("Enter your choice: ");
                return userInput.nextInt();

            } catch (Exception ex) {
                System.out.println(Colors.RED + "invalid selection!"+Colors.RESET);
            }
        }

    }

    public void run(int choice){
        while(true)
        {

            choice = display();

            switch(choice)
            {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;

                case 99:
                    return;

                default:
                    System.out.println(Colors.RED + "****That was an invalid selection.****"+ Colors.RESET);
                    break;
            }

        }
    }

    private void displayVehicles(ArrayList<Vehicle>vehicles){
        for(Vehicle v : vehicles){
            System.out.println(v);
        }
    }

    private void init(){
        fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }
}
