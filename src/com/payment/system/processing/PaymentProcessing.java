package com.payment.system.processing;


import com.payment.system.payments.Payment;

public interface PaymentProcessing
{
    void setPaymentType(Payment payment);

    void setCurrentPrice(double price);

    void completePayment();

}
