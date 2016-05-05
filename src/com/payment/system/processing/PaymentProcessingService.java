package com.payment.system.processing;


import com.payment.system.payments.Payment;
import com.payment.system.PaymentStorage;

public class PaymentProcessingService implements PaymentProcessing
{
    private PaymentStorage paymentStorage = PaymentStorage.getInstance();

    private Payment payment;

    @Override
    public void setPaymentType(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void setCurrentPrice(double price) {
        payment.getSale().setCurrentPrice(price);
    }

    @Override
    public void completePayment() {
        payment.calculateSale();
        payment.saveSaleToStorage();
    }
}
