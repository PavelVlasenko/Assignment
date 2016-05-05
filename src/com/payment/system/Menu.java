package com.payment.system;

import com.payment.system.processing.PaymentProcessing;

import java.util.Scanner;

public class Menu {

    private static final String HEADER = "Payment System\n==========================";
    private static final String MAIN_MENU = "Select an option from the menu below:\n" +
            "1. Standard Payment\n" +
            "2. Loyalty Rewards Payment\n" +
            "3. Employee Payment\n" +
            "4. View Payments Received\n" +
            "5. Exit";

    private PaymentProcessing paymentProcessing;


    public void dispalayMainMenu()
    {
        System.out.println(HEADER);
        System.out.println(MAIN_MENU);

        Scanner scanInput = new Scanner(System.in);
        if(scanInput.hasNextInt())
        {
            int answer = scanInput.nextInt();
            processMenuSelection(answer);
        }

    }

    private void processMenuSelection(int menuSelection) {

        switch (menuSelection){
            case 1:
                System.out.println("--Standard payment--");
                paymentProcessing.setClientType(ClientType.STANDART);
                break;
            case 2:
                System.out.println("--Process loyalty rewards payment--");
                break;
            case 3:
                System.out.println("--Process employee payment--");
                break;
            case 4:
                System.out.println("--View payments received--");
                break;
            case 5:
                System.out.println("--Payments complete.  Goodbye! --");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection! A number between 1 and 5 was expected.");
                dispalayMainMenu();
        }
    }

}
