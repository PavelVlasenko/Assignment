package com.payment.system.payments;


public class LoyaltyPayment extends Payment
{
    @Override
    public void calculateSale() {
        sale.setDiscount(sale.getCurrentPrice()*0.05);
        sale.setTotalPrice(sale.getCurrentPrice() - sale.getDiscount());
    }

    @Override
    public void saveSaleToStorage() {
        paymentStorage.getSales().get(PaymentType.LOYALTY).add(sale);
    }
}
