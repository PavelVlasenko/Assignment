package com.payment.system.processing;


import com.payment.system.Sale;
import com.payment.system.payments.Payment;
import com.payment.system.PaymentStorage;
import com.payment.system.payments.PaymentType;

import java.util.List;

public class PaymentProcessingService implements PaymentProcessing
{
    private static final String SALES_INFO_TEMPLATE = "%-3d  %-7.1f            %-7.1f      %-7.1f";

    private PaymentStorage paymentStorage = PaymentStorage.getInstance();

    private Payment payment;

    @Override
    public void setPaymentType(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void completePayment() {
        payment.calculateSale();
    }

    @Override
    public void saveSaleToStorage() {
        payment.saveSaleToStorage();
    }

    @Override
    public Payment getPayment() {
        return payment;
    }

    @Override
    public void displayAllSales() {
        System.out.println("\n================== Standard client sales =========================");
        System.out.println("N    Current price     Discount     Total price");
        List<Sale> standardSales = paymentStorage.getSales().get(PaymentType.STANDARD);
        displaySalesInfo(standardSales);

        System.out.println("\n================== Loyalty client sales =========================");
        System.out.println("N    Current price     Discount     Total price");
        List<Sale> loyaltySales = paymentStorage.getSales().get(PaymentType.LOYALTY);
        displaySalesInfo(loyaltySales);

        System.out.println("\n================== Employee client sales =========================");
        System.out.println("N    Current price     Discount     Total price");
        List<Sale> employeeSales = paymentStorage.getSales().get(PaymentType.EMPLOYEE);
        displaySalesInfo(employeeSales);
    }

    private void displaySalesInfo(List<Sale> sales)
    {
        double totalDiscount = 0;
        double totalSalesAmount = 0;
        for(Sale sale : sales)
        {
            totalDiscount+=sale.getDiscount();
            totalSalesAmount+=sale.getTotalPrice();
            System.out.println(String.format(SALES_INFO_TEMPLATE, sales.indexOf(sale), sale.getCurrentPrice(), sale.getDiscount(), sale.getTotalPrice()));
        }

        System.out.println("Total discount: " + totalDiscount);
        System.out.println("Total sales amount: " + totalSalesAmount);
    }

}
