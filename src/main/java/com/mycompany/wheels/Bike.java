package com.mycompany.wheels;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bike {
    protected String model;
    protected double deposit = 0;
    protected double rate = 0;
    protected int bikeNumber = 0;
    private static List<Bike> bikeList = new ArrayList<>();
    private static final String filePath = "Local_Bikes.csv";


    public Bike(String model, int bikeNumber, double deposit, double rate) {
        this.model = model;
        this.rate = rate;
        this.bikeNumber = bikeNumber;
        this.deposit = deposit;
    }

    public String getModel() {
        return model;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getRate() {
        return rate;
    }

    public int getBikeNumber() {
        return bikeNumber;
    }

    public static Bike findBikeByNumber(int bikeNum, List<Bike> bikeList) {
        for (Bike bike : bikeList) {
            if (bike.getBikeNumber() == bikeNum) {
                return bike;
            }
        }
        return null;
    }

    public static void registerBike(String model, int number, double deposit, double rate) {
        Bike newBike = new Bike(model, number, deposit, rate);
        bikeList.add(newBike);
        Data.saveToLocal(bikeList, filePath);
    }

    public static Bike showDetailsForBike(int bikeNumber) {
        List<Bike> bikeList = Data.readLocal(filePath);
        return Bike.findBikeByNumber(bikeNumber, bikeList);
    }

    public static void rentBike(String customerName, String customerPostcode, String customerTelephone, int numberOfDays, int bikeNumber) {
        List<Bike> bikeList = Data.readLocal(filePath);
        Bike selectedBike = Bike.findBikeByNumber(bikeNumber, bikeList);
        if (selectedBike != null) {
            Customer customerRental = new Customer(customerName, customerPostcode, customerTelephone);
            Hire hire = new Hire(new Date(), numberOfDays, selectedBike, customerRental);
            Statistics.recordHire(hire);

            double cost = selectedBike.calculateCost(numberOfDays);
            JOptionPane.showMessageDialog(null, "Rental cost: £" + cost, "Rental Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Bike not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public double calculateCost(int numberOfDays) {
        return deposit + (rate * numberOfDays);
    }
}