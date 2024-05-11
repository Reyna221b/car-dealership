package org.pluralsight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest
{
    private Dealership dealership;

    @BeforeEach
    public void setUp() {
        // Create a sample dealership with vehicles for testing
        dealership = new Dealership("Test Dealership", "123 Main St", "555-1234");
        dealership.addVehicle(new Vehicle(1, 2000, "Toyota", "Corolla", "Sedan", "Red", 10000, 5000));
        dealership.addVehicle(new Vehicle(2, 2010, "Ford", "Fusion", "Sedan", "Black", 20000, 8000));
        dealership.addVehicle(new Vehicle(3, 2015, "Honda", "Civic", "Sedan", "Blue", 15000, 10000));
        dealership.addVehicle(new Vehicle(4, 2010, "Toyota", "Corolla","Sedan", "Red", 11000, 9000));
    }

    @Test
    public void testGetVehicleByPrice() {
        List<Vehicle> vehicles = dealership.getVehicleByPrice(7000, 10000);
        assertEquals(2, vehicles.size());
        assertTrue(vehicles.stream().allMatch(v -> v.getPrice() >= 7000 && v.getPrice() <= 10000));
    }

    @Test
    public void testGetVehicleByMakeModel() {
        List<Vehicle> vehicles = dealership.getVehicleByMakeModel("Toyota", "Corolla");
        assertEquals(1, vehicles.size());
        assertTrue(vehicles.stream().allMatch(v -> v.getMake().equalsIgnoreCase("Toyota") && v.getModel().equalsIgnoreCase("Corolla")));
    }

    @Test
    public void testGetVehicleByYear() {
        List<Vehicle> vehicles = dealership.getVehicleByYear(2005, 2015);
        assertEquals(2, vehicles.size());
        assertTrue(vehicles.stream().allMatch(v -> v.getYear() >= 2005 && v.getYear() <= 2015));
    }

    @Test
    public void testGetVehicleByColor() {
        List<Vehicle> vehicles = dealership.getVehicleByColor("Red");
        assertEquals(2, vehicles.size());
        assertTrue(vehicles.stream().allMatch(v -> v.getColor().equalsIgnoreCase("Red")));
    }

    @Test
    public void testGetVehicleByMileage() {
        List<Vehicle> vehicles = dealership.getVehicleByMileage(10000, 20000);

        assertEquals(3, vehicles.size());
        assertTrue(vehicles.stream().allMatch(v -> v.getOdometer() >= 10000 && v.getOdometer() <= 20000));
    }

    @Test
    public void testGetVehicleByType() {
        List<Vehicle> vehicles = dealership.getVehicleByType("Sedan");

        assertEquals(4, vehicles.size());
        assertTrue(vehicles.stream().allMatch(v -> v.getVehicleType().equalsIgnoreCase("Sedan")));
    }

    @Test
    public void testGetAllVehicles() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        assertEquals(3, vehicles.size());
    }

    @Test
    public void testAddVehicle() {
        dealership.addVehicle(new Vehicle(4, 2018, "Tesla", "Model S", "White", "Sedan", 5000, 70000));
        List<Vehicle> vehicles = dealership.getAllVehicles();
        assertEquals(4, vehicles.size());
    }

    @Test
    public void testRemoveVehicle() {
        Vehicle vehicle = new Vehicle(1, 2000, "Toyota", "Corolla", "Red", "Sedan", 10000, 5000);

        dealership.removeVehicle(vehicle);

        List<Vehicle> vehicles = dealership.getAllVehicles();
        assertEquals(4, vehicles.size());

        assertTrue(vehicles.stream().anyMatch(v -> v.getVin() == 1));
    }

}