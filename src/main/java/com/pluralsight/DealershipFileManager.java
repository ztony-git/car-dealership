package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;

public class DealershipFileManager {
    private static final String FILE = "inventory.csv";

    public Dealership getDealership() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE));

            // first line is dealership
            String line = br.readLine();

            // name|address|phone#
            String[] dealershipInfo = line.split("\\|");
            Dealership dealership = new Dealership(dealershipInfo[0], dealershipInfo[1], dealershipInfo[2]);

            // populate dealership
            while ((line = br.readLine()) != null) {
                // vin|year|make|model|type|color|odometer|price
                String[] vehicleInfo = line.split("\\|");
                Vehicle vehicle = new Vehicle(
                        Integer.parseInt(vehicleInfo[0]),
                        Integer.parseInt(vehicleInfo[1]),
                        vehicleInfo[2],
                        vehicleInfo[3],
                        vehicleInfo[4],
                        vehicleInfo[5],
                        Integer.parseInt(vehicleInfo[6]),
                        new BigDecimal(vehicleInfo[7])
                );

                dealership.addVehicle(vehicle);
            }

            return dealership;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void saveDealership(Dealership dealership) {}
}
