package org.pluralsight;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager
{
    public Dealership dealership;
    public boolean firstLine;


    public Dealership getDealership(){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        File file = new File("files/inventory.csv");

        try(FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader)
        )
        {
            firstLine = true;
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();

                Scanner lineScanner = new Scanner(line);

                lineScanner.useDelimiter("\\|");

                if(firstLine){
                    String dealershipName = lineScanner.next();
                    String dealershipAddress = lineScanner.next();
                    String dealershipPhone = lineScanner.next();
                    dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhone);
                    firstLine = false;
                    continue;
                }

                int vin = lineScanner.nextInt();
                int year= lineScanner.nextInt();
                String make = lineScanner.next();
                String model = lineScanner.next();
                String vehicleType = lineScanner.next();
                String color = lineScanner.next();
                int odometer = lineScanner.nextInt();
                double price = lineScanner.nextDouble();

                Vehicle vehicleEntry = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);

                dealership.addVehicle(vehicleEntry);

            }

        }
        catch (IOException ex)
        {
            System.out.println("Error reading file or somethin");

        }
        return dealership;
    }

    public void saveDealership()
    {

    }

}




