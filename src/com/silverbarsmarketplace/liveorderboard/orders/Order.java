package com.silverbarsmarketplace.liveorderboard.orders;

/**
 * Created by parisfreire on 21/02/2019.
 */
public abstract class Order {

    int userId;
    double orderQuantity;
    int pricePerKg;

    /* Getters and Setters */

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(int pricePerKg) {
        this.pricePerKg = pricePerKg;
    }


}
