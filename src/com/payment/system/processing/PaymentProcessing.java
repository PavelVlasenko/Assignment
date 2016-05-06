package com.payment.system.processing;


import com.payment.system.payments.Payment;

public interface PaymentProcessing
{
    void setPaymentType(Payment payment);

    void completePayment();

    void saveSaleToStorage();

    Payment getPayment();

    void displayAllSales();

}
