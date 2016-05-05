package com.payment.system.payments;

import com.payment.system.PaymentStorage;
import com.payment.system.Sale;

public abstract class Payment
{
    protected Sale sale = new Sale();
    protected PaymentStorage paymentStorage = PaymentStorage.getInstance();

    public Sale getSale() {
        return sale;
    }

    public abstract void calculateSale();

    public abstract void saveSaleToStorage();

}
