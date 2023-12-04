package com.mycompany.wheels;

import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WheelsUI extends JFrame {
    private JPanel mainPanel;

    public WheelsUI() {
        super("Wheels Internal System");
        initializeComponents();
    }

    private void initializeComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2));

        JButton registerBikeButton = new JButton("Register New Bike");
        JButton showDetailsButton = new JButton("Show Bike Details");
        JButton rentBikeButton = new JButton("Rent Bike");
        JButton printReceiptButton = new JButton("Print Payment Receipt");
        JButton showStatisticsButton = new JButton("Show Store's Statistics");

        registerBikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegisterBikePage();
            }
        });

        showDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openShowDetailsPage();
            }
        });

        rentBikeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRentBikePage();
            }
        });

        printReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPrintReceiptPage();
            }
        });

        showStatisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openStatisticsPage();
            }
        });

        mainPanel.add(registerBikeButton);
        mainPanel.add(showDetailsButton);
        mainPanel.add(rentBikeButton);
        mainPanel.add(printReceiptButton);
        mainPanel.add(showStatisticsButton);

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void openRegisterBikePage() {
        JFrame registerBikeFrame = new JFrame("Register New Bike");
        JPanel registerBikePanel = new JPanel(new GridLayout(5, 2));

        JTextField modelField = new JTextField();
        JTextField numberField = new JTextField();
        JTextField depositField = new JTextField();
        JTextField rateField = new JTextField();

        JButton registerButton = new JButton("Register Bike");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bike.registerBike(modelField.getText(), Integer.parseInt(numberField.getText()),Double.parseDouble(depositField.getText()), Double.parseDouble(rateField.getText()));
                JOptionPane.showMessageDialog(registerBikeFrame, "Bike registered successfully!");
                registerBikeFrame.dispose();
            }
        });

        registerBikePanel.add(new JLabel("Model:"));
        registerBikePanel.add(modelField);
        registerBikePanel.add(new JLabel("Number:"));
        registerBikePanel.add(numberField);
        registerBikePanel.add(new JLabel("Deposit:"));
        registerBikePanel.add(depositField);
        registerBikePanel.add(new JLabel("Daily Rate:"));
        registerBikePanel.add(rateField);
        registerBikePanel.add(new JLabel(""));
        registerBikePanel.add(registerButton);

        registerBikeFrame.getContentPane().add(registerBikePanel);
        registerBikeFrame.setSize(400, 200);
        registerBikeFrame.setLocationRelativeTo(null);
        registerBikeFrame.setVisible(true);
    }

    private void openShowDetailsPage() {
        JFrame showDetailsFrame = new JFrame("Show Bike Details");
        JPanel showDetailsPanel = new JPanel(new GridLayout(5, 2));

        JTextField bikeNumberField = new JTextField();
        JButton showDetailsButton = new JButton("Show Details");

        showDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bikeNumber = Integer.parseInt(bikeNumberField.getText());
                Bike selectedBike = Bike.showDetailsForBike(bikeNumber);
                if (selectedBike != null) {
                    JFrame detailsFrame = new JFrame("Bike Details");
                    JPanel detailsPanel = new JPanel(new GridLayout(5, 2));

                    detailsPanel.add(new JLabel("Bike Number:"));
                    detailsPanel.add(new JLabel(Integer.toString(selectedBike.getBikeNumber())));
                    detailsPanel.add(new JLabel("Model:"));
                    detailsPanel.add(new JLabel(selectedBike.getModel()));
                    detailsPanel.add(new JLabel("Deposit:"));
                    detailsPanel.add(new JLabel(Double.toString(selectedBike.getDeposit())));
                    detailsPanel.add(new JLabel("Daily Rate:"));
                    detailsPanel.add(new JLabel(Double.toString(selectedBike.getRate())));

                    detailsFrame.getContentPane().add(detailsPanel);
                    detailsFrame.setSize(400, 200 );
                    detailsFrame.setLocationRelativeTo(null);
                    detailsFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Bike not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                showDetailsFrame.dispose();
            }
        });

        showDetailsPanel.add(new JLabel("Bike Number:"));
        showDetailsPanel.add(bikeNumberField);
        showDetailsPanel.add(new JLabel(""));
        showDetailsPanel.add(showDetailsButton);

        showDetailsFrame.getContentPane().add(showDetailsPanel);
        showDetailsFrame.setSize(400, 200);
        showDetailsFrame.setLocationRelativeTo(null);
        showDetailsFrame.setVisible(true);
    }

    private void openRentBikePage() {
        JFrame rentBikeFrame = new JFrame("Rent Bike");
        JPanel rentBikePanel = new JPanel(new GridLayout(6, 2));

        JTextField bikeNumberField = new JTextField();
        JTextField customerNameField = new JTextField();
        JTextField customerPostcodeField = new JTextField();
        JTextField customerTelephoneField = new JTextField();
        JTextField numberOfDaysField = new JTextField();

        JButton rentButton = new JButton("Rent Bike");

        rentButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Bike.rentBike(customerNameField.getText(),
                        customerPostcodeField.getText(),
                        customerTelephoneField.getText(),
                        Integer.parseInt(numberOfDaysField.getText()),
                        Integer.parseInt(bikeNumberField.getText()));
                rentBikeFrame.dispose();
            }
        });

        rentBikePanel.add(new JLabel("Bike Number:"));
        rentBikePanel.add(bikeNumberField);
        rentBikePanel.add(new JLabel("Customer Name:"));
        rentBikePanel.add(customerNameField);
        rentBikePanel.add(new JLabel("Customer Postcode:"));
        rentBikePanel.add(customerPostcodeField);
        rentBikePanel.add(new JLabel("Customer Telephone:"));
        rentBikePanel.add(customerTelephoneField);
        rentBikePanel.add(new JLabel("Number of Days:"));
        rentBikePanel.add(numberOfDaysField);
        rentBikePanel.add(new JLabel(""));
        rentBikePanel.add(rentButton);

        rentBikeFrame.getContentPane().add(rentBikePanel);
        rentBikeFrame.setSize(400, 300);
        rentBikeFrame.setLocationRelativeTo(null);
        rentBikeFrame.setVisible(true);
    }

    private void openPrintReceiptPage() {
        JFrame printReceiptFrame = new JFrame("Print Payment Receipt");
        JPanel printReceiptPanel = new JPanel(new GridLayout(3, 2));

        JTextField hireIdField = new JTextField();
        JButton printReceiptButton = new JButton("Print Receipt");

        printReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hireId = Integer.parseInt(hireIdField.getText());
                Hire hire = Hire.findHireById(hireId);

                if (hire != null) {
                    Payment.issueReceipt(hire);
                    JOptionPane.showMessageDialog(null, "Displaying Receipt: ");
                    printReceiptFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Hire not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        printReceiptPanel.add(new JLabel("Hire ID:"));
        printReceiptPanel.add(hireIdField);
        printReceiptPanel.add(new JLabel(""));
        printReceiptPanel.add(printReceiptButton);

        printReceiptFrame.getContentPane().add(printReceiptPanel);
        printReceiptFrame.setSize(400, 200);
        printReceiptFrame.setLocationRelativeTo(null);
        printReceiptFrame.setVisible(true);
    }


    private void openStatisticsPage() {
            JFrame statisticsFrame = new JFrame("Store Statistics");
            JPanel statisticsPanel = new JPanel(new GridLayout(3, 2));

            Bike mostHiredBike = Statistics.getMostHiredBike();
            Customer mostFrequentCustomer = Statistics.getMostFrequentCustomer();

            JLabel mostHiredBikeLabel = new JLabel("Most Hired Bike: " + (mostHiredBike != null ? mostHiredBike.getModel() : "N/A"));
            JLabel mostFrequentCustomerLabel = new JLabel("Most Frequent Customer: " + (mostFrequentCustomer != null ? mostFrequentCustomer.getName() : "N/A"));

            statisticsPanel.add(mostHiredBikeLabel);
            statisticsPanel.add(mostFrequentCustomerLabel);

            statisticsFrame.getContentPane().add(statisticsPanel);
            statisticsFrame.setSize(400, 200);
            statisticsFrame.setLocationRelativeTo(null);
            statisticsFrame.setVisible(true);
        }
    }
