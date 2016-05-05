package com.payment.system;

public enum ClientType
{
    STANDART(0),
    LOYALTY(5),
    EMPLOYEE(10);

    private int discount;

    ClientType(int discount) {
        this.discount = discount;
    }


    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
