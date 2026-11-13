package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {}

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("99")) {
            seperator();
            displayMainMenu(dealership.getName());
            System.out.print("Command: ");
            input = scanner.nextLine();

            switch (input) {
                case "1" -> { processGetByPriceRequest(scanner); }
                case "2" -> { processGetByMakeModelRequest(scanner); }
                case "3" -> { processGetByYearRequest(scanner); }
                case "4" -> { processGetByColorRequest(scanner); }
                case "5" -> { processGetByMileageRequest(scanner); }
                case "6" -> { processGetByVehicleTypeRequest(scanner); }
                case "7" -> { processGetAllVehiclesRequest(); }
                case "8" -> { processAddVehicleRequest(); }
                case "9" -> { processRemoveVehicleRequest(); }
                case "99" -> { return; }
                default -> {
                    System.out.println("Invalid input");
                }
            }
        }
    };

    public void processGetByPriceRequest(Scanner scanner) {
        seperator();
        BigDecimal minPriceRange = null;
        BigDecimal maxPriceRange = null;

        while (minPriceRange == null) {
            System.out.print("Min Price Range: $");
            String input = scanner.nextLine().trim();
            try {
                minPriceRange = new BigDecimal(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input: " + e.getMessage());
            }
        }

        while (maxPriceRange == null) {
            System.out.print("Max Price Range: $");
            String input = scanner.nextLine().trim();
            try {
                maxPriceRange = new BigDecimal(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input: " + e.getMessage());
            }
        }

        displayVehicles(dealership.getVehiclesByPrice(minPriceRange, maxPriceRange));
    }

    public void processGetByMakeModelRequest(Scanner scanner) {
        seperator();

        System.out.print("Make: ");
        String make = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest(Scanner scanner) {
        seperator();
        int minYearRange = -1;
        int maxYearRange = -1;

        while (minYearRange == -1) {
            System.out.print("Min Year Range: ");
            String input = scanner.nextLine().trim();
            try {
                minYearRange = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid Input: " + e.getMessage());
            }
        }

        while (maxYearRange == -1) {
            System.out.print("Max Year Range: ");
            String input = scanner.nextLine().trim();
            try {
                maxYearRange = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid Input: " + e.getMessage());
            }
        }

        displayVehicles(dealership.getVehiclesByYear(minYearRange, maxYearRange));}

    public void processGetByColorRequest(Scanner scanner) {
        seperator();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest(Scanner scanner) {
        seperator();
        int minMileageRange = -1;
        int maxMileageRange = -1;

        while (minMileageRange == -1) {
            System.out.print("Min Mileage Range: ");
            String input = scanner.nextLine().trim();
            try {
                minMileageRange = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid Input: " + e.getMessage());
            }
        }

        while (maxMileageRange == -1) {
            System.out.print("Max Mileage Range: ");
            String input = scanner.nextLine().trim();
            try {
                maxMileageRange = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid Input: " + e.getMessage());
            }
        }

        displayVehicles(dealership.getVehiclesByMileage(minMileageRange, maxMileageRange));}

    public void processGetByVehicleTypeRequest(Scanner scanner) {
        seperator();

        System.out.print("Vehicle Type: ");
        String type = scanner.nextLine();

        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {}

    public void processRemoveVehicleRequest() {}

    /***************************************
    * HELPER
     **************************************/

    private void displayMainMenu(String dealershipName) {
        System.out.println(dealershipName + "\n" +
                "1 - Find vehicles within a price range\n" +
                "2 - Find vehicles by make / model\n" +
                "3 - Find vehicles by year\n" +
                "4 - Find vehicles by color\n" +
                "5 - Find vehicles by mileage\n" +
                "6 - Find vehicles by vehicle type\n" +
                "7 - List ALL vehicles\n" +
                "8 - Add a vehicle\n" +
                "9 - Remove a vehicle\n" +
                "99 - Quit");
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        System.out.printf("%-25s | %-10s | %-10s | %-10s | %-4s | %-6s%n", "Make & Model", "Price", "Color", "Mileage", "Year", "Vin");
        seperator();

        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-25s | %-10.2f | %-10s | %-10d | %-4d | %-6d%n", (vehicle.getMake() + " " + vehicle.getModel()),
                    vehicle.getPrice(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getYear(), vehicle.getVin());
        }
    }

    private void seperator() {
        System.out.println("--------------------------------------------------------------------------------");
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }
}
