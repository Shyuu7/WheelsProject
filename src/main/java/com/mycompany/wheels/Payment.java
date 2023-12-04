package com.mycompany.wheels;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Payment {
    private Customer customer;

    public Payment(Customer cust) {
        customer = cust;
    }

    public static void issueReceipt(Hire hire) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                PDType1Font font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
                contentStream.setFont(font, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(50, page.getMediaBox().getHeight() - 50);
                contentStream.showText("Wheels Store - Receipt #" + hire.getHireId());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("================================================================");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Customer: " + hire.getCustomer().getName());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Telephone: " + hire.getCustomer().getTelephone());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Zipcode: " + hire.getCustomer().getPostcode());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("================================================================");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Bike: " + hire.getBike().getModel());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Days: " + hire.getNumberOfDays());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("================================================================");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Date: " + hire.getStartDate());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Total: £" + hire.getBike().calculateCost(hire.getNumberOfDays()));
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("================================================================");
                contentStream.endText();
            }

            File pdfFile = new File("Receipt" + hire.getHireId() + ".pdf");
            document.save(pdfFile);
            Desktop.getDesktop().open(pdfFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
