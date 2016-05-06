package com.payment.system;

import com.payment.system.payments.EmployeePayment;
import com.payment.system.payments.LoyaltyPayment;
import com.payment.system.payments.StandardPayment;
import com.payment.system.processing.PaymentProcessing;
import com.payment.system.processing.PaymentProcessingService;

import java.util.Scanner;

public class Menu {

    private static final String HEADER = "=========================\n       Payment System\n==========================";
    private static final String MAIN_MENU = "Select an option from the menu below:\n" +
            "1. Standard Payment\n" +
            "2. Loyalty Rewards Payment\n" +
            "3. Employee Payment\n" +
            "4. View Payments Received\n" +
            "5. Exit";

    private static boolean finished = false;

    private PaymentProcessing paymentProcessing = new PaymentProcessingService();

    public void displayMainMenu() {

        while (!finished) {
            System.out.println(HEADER);
            System.out.println(MAIN_MENU);

            Scanner scanInput = new Scanner(System.in);
            int answer = 0;
            if (scanInput.hasNextInt()) {
                answer = scanInput.nextInt();
            }
            switch (answer) {
                case 1:
                    System.out.println("==== Process standard payment ====");
                    paymentProcessing.setPaymentType(new StandardPayment());
                    System.out.println("Enter current price: ");
                    processPayment();
                    break;
                case 2:
                    System.out.println("==== Process loyalty rewards payment ====");
                    paymentProcessing.setPaymentType(new LoyaltyPayment());
                    System.out.println("Enter current price:");
                    processPayment();
                    break;
                case 3:
                    System.out.println("==== Process employee payment ====");
                    paymentProcessing.setPaymentType(new EmployeePayment());
                    System.out.println("Enter current price: ");
                    processPayment();
                    break;
                case 4:
                    System.out.println("==== View payments received ====");
                    paymentProcessing.displayAllSales();
                    break;
                case 5:
                    System.out.println("==== Payments complete.  Goodbye! ====");
                    finished = true;
                    break;
                default:
                    System.out.println("Invalid selection! A number between 1 and 5 was expected.");
                    break;
            }
        }
    }

    private void processPayment()
    {
        Scanner scanInput = new Scanner(System.in);
        if(scanInput.hasNextDouble())
        {
            double price = scanInput.nextDouble();
            paymentProcessing.getPayment().getSale().setCurrentPrice(price);
            paymentProcessing.completePayment();
            paymentProcessing.saveSaleToStorage();
            System.out.println("==== Total price(with discount): " + paymentProcessing.getPayment().getSale().getTotalPrice() + " =====");
        }
        else
        {
            System.out.println("Enter a valid price");
        }
    }

}
