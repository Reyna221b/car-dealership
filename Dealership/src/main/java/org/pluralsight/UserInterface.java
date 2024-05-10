package org.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface
{
    static final Scanner userInput = new Scanner(System.in);
    public Dealership dealership;
    public DealershipFileManager fileManager;
    public List<Vehicle> vehicleList;

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
                int choice = userInput.nextInt();

                switch (choice) {
                    case 1:
                        //processGetByPriceRequest();
                        break;
                    case 2:
                      //  processGetByMakeModelRequest();
                        break;
                    case 3:
                      //  processGetByYearRequest();
                        break;
                    case 4:
                       // processGetByColorRequest();
                        break;
                    case 5:
                        //processGetByMilageRequest();
                        break;
                    case 6:
                       // processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processGetAllVehiclesRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        //processRemoveVehicleRequest();
                        break;
                    case 99:
                        return 0;
                        //System.exit(0);
                        //break;
                    default:
                        System.out.println("Invalid Input.");
                }


            } catch (Exception ex) {
                System.out.println(Colors.RED + "invalid selection!"+Colors.RESET);
            }
        }

    }
    public void processAddVehicleRequest()
    {
        try{

            System.out.print("Please enter the vin");
            int vin = Integer.parseInt(userInput.nextLine().strip());

            System.out.print("Enter the year: ");
            int year = Integer.parseInt(userInput.nextLine().strip());

            System.out.print("Enter the make: ");
            String make = userInput.nextLine().strip();
            System.out.print("Enter the model: ");
            String model = userInput.nextLine().strip();
            System.out.print("Enter the color: ");
            String color = userInput.nextLine().strip();


            System.out.print("Enter the odometer: ");
            int odometer = Integer.parseInt(userInput.nextLine().strip());

            System.out.print("Enter the price: ");
            double price = Double.parseDouble(userInput.nextLine().strip());



        }
        catch (Exception e){

        }

    }

    private void displayVehicles(List<Vehicle>vehicles){
        if(vehicles.isEmpty()){
            System.out.println("Sorry no matches!");
            return;
        }
        for(Vehicle v : vehicles){
            System.out.println(v);
        }
    }

    private void init(){
        fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    public void processGetAllVehiclesRequest(){
        vehicleList = dealership.getAllVehicles();
        displayVehicles(vehicleList);

    }
}
