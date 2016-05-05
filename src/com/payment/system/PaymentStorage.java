package com.payment.system;

import com.payment.system.payments.PaymentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentStorage
{
    private static PaymentStorage instance = new PaymentStorage();

    private Map<PaymentType, List<Sale>> sales;

    private PaymentStorage()
    {
        sales = new HashMap<PaymentType, List<Sale>>();
        sales.put(PaymentType.STANDARD, new ArrayList<Sale>());
        sales.put(PaymentType.LOYALTY, new ArrayList<Sale>());
        sales.put(PaymentType.EMPLOYEE, new ArrayList<Sale>());
    }

    public void displayAllSales()
    {

    }

    public Map<PaymentType, List<Sale>> getSales() {
        return sales;
    }

    public static PaymentStorage getInstance(){
        return instance;
    }

}
