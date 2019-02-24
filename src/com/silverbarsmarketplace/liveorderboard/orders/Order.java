package com.silverbarsmarketplace.liveorderboard.orders;

import java.util.Comparator;

/**
 * Created by parisfreire on 21/02/2019.
 */
public abstract class Order{

    int userId;
    double orderQuantity;
    int pricePerKg;

    /* Getters and Setters */
        public int getUserId() {
            return userId;
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


    public static Comparator getComparatorByPrice(){
        Comparator<Order> compareByPrice = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Integer.compare(o1.pricePerKg, o2.pricePerKg);
            }
        };

        return compareByPrice;
    }

    public static Comparator getComparatorByPriceReversed(){
        Comparator<Order> compareByPriceReversed = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Integer.compare(o2.pricePerKg, o1.pricePerKg);
            }
        };

        return compareByPriceReversed;
    }




}
