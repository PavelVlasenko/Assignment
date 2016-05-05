package com.payment.system.payments;


public class EmployeePayment extends Payment
{
    @Override
    public void calculateSale() {
        sale.setDiscount(sale.getCurrentPrice()*0.1);
        sale.setTotalPrice(sale.getCurrentPrice() - sale.getDiscount());
    }

    @Override
    public void saveSaleToStorage() {
        paymentStorage.getSales().get(PaymentType.EMPLOYEE).add(sale);
    }
}
