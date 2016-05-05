package com.payment.system.processing;


import com.payment.system.PaymentStorage;

public class PaymentProcessingService implements PaymentProcessing
{
    private PaymentStorage paymentStorage = PaymentStorage.getInstance();


}
