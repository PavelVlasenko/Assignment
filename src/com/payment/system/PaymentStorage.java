package com.payment.system;

public class PaymentStorage
{
    private static PaymentStorage instance = new PaymentStorage();

    private PaymentStorage()
    {
        //singleton class
    }

    public static PaymentStorage getInstance(){
        return instance;
    }

}
