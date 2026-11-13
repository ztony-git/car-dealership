package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        List<Vehicle> returnVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            BigDecimal price = vehicle.getPrice();
            if (price.compareTo(min) >= 0 && price.compareTo(max) <= 0) {
                returnVehicles.add(vehicle);
            }
        }

        return returnVehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> returnVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                returnVehicles.add(vehicle);
            }
        }

        return returnVehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> returnVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            int year = vehicle.getYear();
            if (year >= min && year <= max) {
                returnVehicles.add(vehicle);
            }
        }

        return returnVehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> returnVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equals(color)) {
                returnVehicles.add(vehicle);
            }
        }

        return returnVehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> returnVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            int mileage = vehicle.getOdometer();
            if (mileage >= min && mileage <= max) {
                returnVehicles.add(vehicle);
            }
        }

        return returnVehicles;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> returnVehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equals(vehicleType)) {
                returnVehicles.add(vehicle);
            }
        }

        return returnVehicles;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {}
}
