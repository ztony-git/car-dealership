package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {}

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("99")) {
            displayMainMenu(dealership.getName());
            System.out.print("Command: ");
            input = scanner.nextLine();

            switch (input) {
                case "1" -> { processGetByPriceRequest(); }
                case "2" -> { processGetByMakeModelRequest(); }
                case "3" -> { processGetByColorRequest(); }
                case "4" -> { processGetByMileageRequest(); }
                case "5" -> { processGetByVehicleTypeRequest(); }
                case "6" -> { processGetAllVehiclesRequest(); }
                case "7" -> { processAddVehicleRequest(); }
                case "8" -> { processRemoveVehicleRequest(); }
                case "99" -> { return; }
                default -> {
                    System.out.println("Invalid input");
                }
            }
        }
    };

    public void processGetByPriceRequest() {}

    public void processGetByMakeModelRequest() {}

    public void processGetByColorRequest() {}

    public void processGetByMileageRequest() {}

    public void processGetByVehicleTypeRequest() {}

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
                "3 - Find vehicles by color\n" +
                "4 - Find vehicles by mileage\n" +
                "5 - Find vehicles by vehicle type\n" +
                "6 - List ALL vehicles\n" +
                "7 - Add a vehicle\n" +
                "8 - Remove a vehicle\n" +
                "99 - Quit");
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        vehicles.forEach(System.out::println);
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }
}
