package com.mycompany.wheels;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private static Map<Bike, Integer> bikeHireCount = new HashMap<>();
    private static Map<Customer, Integer> customerCount = new HashMap<>();
    private static Map<Hire, Integer> hireCount = new HashMap<>();

    public static void recordHire(Hire hire) {
        hireCount.put(hire, hireCount.getOrDefault(hire, 0) + 1);

        Bike bike = hire.getBike();
        bikeHireCount.put(bike, bikeHireCount.getOrDefault(bike, 0) + 1);

        Customer customer = hire.getCustomer();
        customerCount.put(customer, customerCount.getOrDefault(customer, 0) + 1);
    }

    public static Bike getMostHiredBike() {
        int maxHireCount = 0;
        Bike mostHiredBike = null;

        for (Map.Entry<Bike, Integer> entry : bikeHireCount.entrySet()) {
            if (entry.getValue() > maxHireCount) {
                maxHireCount = entry.getValue();
                mostHiredBike = entry.getKey();
            }
        }
        return mostHiredBike;
    }

    public static Customer getMostFrequentCustomer() {
        int highestCounter = 0;
        Customer mostFrequentCustomer = null;

        for (Map.Entry<Customer, Integer> entry : customerCount.entrySet()) {
            if (entry.getValue() > highestCounter) {
                highestCounter = entry.getValue();
                mostFrequentCustomer = entry.getKey();
            }
        }
        return mostFrequentCustomer;
    }

}

