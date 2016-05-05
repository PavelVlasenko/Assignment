package com.payment.system.payments;


public class StandardPayment extends Payment
{
    @Override
    public void calculateSale() {
        sale.setTotalPrice(sale.getCurrentPrice());
    }

    @Override
    public void saveSaleToStorage() {
        paymentStorage.getSales().get(PaymentType.STANDARD).add(sale);
    }
}
