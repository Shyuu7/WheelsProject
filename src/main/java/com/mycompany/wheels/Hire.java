package com.mycompany.wheels;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hire {
    private Date startDate;
    private Customer customer;
    private Bike bike;
    private int numberOfDays;
    private int hireId;
    private static List<Hire> hireList = new ArrayList<>();

    public Hire(Date startDate, int numberOfDays, Bike bike, Customer customer) {
        this.startDate = startDate;
        this.numberOfDays = numberOfDays;
        this.bike = bike;
        this.customer = customer;
        this.hireId = hireList.size() + 1;
        hireList.add(this);
    }

    public Date getStartDate() {
        return startDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Bike getBike() {
        return bike;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getHireId() { return hireId;}

    public static Hire findHireById(int hireId) {
        for (Hire hire : hireList) {
            if (hire.hireId == hireId) {
                return hire;
            }
        }
        return null;
    }
}