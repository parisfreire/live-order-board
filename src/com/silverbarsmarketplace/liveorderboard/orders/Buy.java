package com.silverbarsmarketplace.liveorderboard.orders;

/**
 * Created by parisfreire on 21/02/2019.
 */
public class Buy extends Order{

    final String type = "BUY";

    public Buy(int userId, int pricePerKg, double orderQuantity){
        this.userId = userId;
        this.pricePerKg = pricePerKg;
        this.orderQuantity = orderQuantity;
    }

}
