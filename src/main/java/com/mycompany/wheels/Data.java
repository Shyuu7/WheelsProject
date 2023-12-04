package com.mycompany.wheels;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.io.File;

public class Data {
    public static void saveToLocal(List<Bike> bikeList, String filePath) {
        boolean fileExists = new File(filePath).exists();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if (!fileExists) {
                writer.write("BikeNumber;Model;Deposit;Rate");
                writer.newLine();
            }

            for (Bike bike : bikeList) {
                writer.write(String.format(Locale.US, "%d;%s;%,.2f;%,.2f",
                        bike.getBikeNumber(),
                        bike.getModel(),
                        bike.getDeposit(),
                        bike.getRate()));
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Bike> readLocal(String filePath) {
        List<Bike> bikeList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    int bikeNumber = Integer.parseInt(parts[0]);
                    String model = parts[1];
                    double deposit = Double.parseDouble(parts[2]);
                    double rate = Double.parseDouble(parts[3]);
                    Bike bike = new Bike(model, bikeNumber, deposit, rate);
                    bikeList.add(bike);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return bikeList;
    }
}
