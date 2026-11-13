package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByYear(double min, double max) {
        return new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        return new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return new ArrayList<>();
    }

    public List<Vehicle> getAllVehicles(double min, double max) {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {}
}
