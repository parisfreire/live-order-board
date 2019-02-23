package com.silverbarsmarketplace.liveorderboard;

import com.silverbarsmarketplace.liveorderboard.orders.Buy;
import com.silverbarsmarketplace.liveorderboard.orders.Order;
import com.silverbarsmarketplace.liveorderboard.orders.Sell;
import com.silverbarsmarketplace.liveorderboard.utils.Utils;

import java.util.*;

/**
 * Created by parisfreire on 21/02/2019.
 */

public class LiveOrderBoard {

    private static List<Order> buysList = new ArrayList<>();
    private static List<Order> sellsList = new ArrayList<>();

    public static void start(){
        System.out.println("####################");
        System.out.println("## LiveOrderBoard ##");
        System.out.println("#################### ");

        Scanner sc = new Scanner(System.in);
        short option = 0;

        while (option != 4) {
            displayMenu();
            option = sc.nextShort();
            displayOptionSelected(option);
        }
    }

    private static void displayMenu(){
        System.out.println("1. Register order");
        System.out.println("2. Cancel order");
        System.out.println("3. Summary");
        System.out.println("4. EXIT ");

        Utils.breakLinesInConsole();

        System.out.println("> Enter your option and hit Enter: ");
    }

    private static void displayOptionSelected(short option){
        switch(option) {
            case 1 :
                registerOrder();
                break;
            case 2 :
                Utils.breakLinesInConsole();
                break;
            case 3 :
                Utils.breakLinesInConsole();
                ordersSummary();
                break;
            case 4 :
                System.out.println("Quitting application...");
                break;
            default :
                System.out.println("Wrong option. Please try again.");
                Utils.breakLinesInConsole();
        }
    }

    private static void registerOrder(){

        Order order = null;
        Scanner sc2 = new Scanner(System.in);

        System.out.println("> Is it going to be a BUY or a SELL?: (B/S)");

        char orderType = Character.toUpperCase(sc2.next().charAt(0));
        int userId, pricePerKg;
        double orderQuantity;

        if(orderType == 'B'){

            System.out.println("> Enter your user id: ");
            userId = sc2.nextInt();
            System.out.println("> Enter your order quantity: ");
            orderQuantity = sc2.nextDouble();
            System.out.println("> Enter your price per Kg: ");
            pricePerKg = sc2.nextInt();

            order = new Buy(userId, pricePerKg, orderQuantity);

            updateOrdersList(order, buysList, orderType);

        }else if(orderType == 'S'){

            System.out.println("> Enter your user id: ");
            userId = sc2.nextInt();
            System.out.println("> Enter your order quantity: ");
            orderQuantity = sc2.nextDouble();
            System.out.println("> Enter your price per Kg: ");
            pricePerKg = sc2.nextInt();

            order = new Sell(userId, pricePerKg, orderQuantity);

            updateOrdersList(order, sellsList, orderType);
        }else{
            System.out.println("> Incorrect order. Please try again.");
            Utils.breakLinesInConsole();

            registerOrder();
        }
    }

    private static void updateOrdersList(Order order, List<Order> orderList, char orderType){

        boolean containsSamePrice = false;
        int index = 0;

        if(orderList.size() != 0){
            for (int i = 0; i < orderList.size(); i++) {
                Order o = orderList.get(i);

                if (o.getPricePerKg() == order.getPricePerKg()) {
                    containsSamePrice = true;
                    index = i;
                }
            }

            if(containsSamePrice){
                Order o = orderList.get(index);
                o.setOrderQuantity(o.getOrderQuantity() + order.getOrderQuantity());

                orderList.set(index, o);
            }else{
                orderList.add(order);
            }

        }else{
            orderList.add(order);
        }

        if(orderType == 'B'){
            Comparator comparatorByPriceReversed = order.getComparatorByPriceReversed();
            Collections.sort(orderList, comparatorByPriceReversed);

            System.out.print("You just added a BUY: ");

        }else{

            System.out.print("You just added a SELL: ");

            Comparator comparatorByPrice = order.getComparatorByPrice();
            Collections.sort(buysList, comparatorByPrice);
        }

        System.out.println(order.getOrderQuantity() + "kg for £"+ order.getPricePerKg() + " [user" +order.getUserId()+"]");

        Utils.breakLinesInConsole();
    }

    private static void sumSameQuantityOrders(double quantity1, double quantity2, int index){

        double total = quantity1 + quantity2;

    }

    private static void ordersSummary(){
        System.out.println("Summary information of live orders");

        for (Order sell : sellsList) {
            System.out.println("SELL: "+ sell.getOrderQuantity() + "kg for £"+ sell.getPricePerKg());
        }

        for (Order buy : buysList) {
            System.out.println("BUY: "+ buy.getOrderQuantity() + "kg for £"+ buy.getPricePerKg());
        }

        Utils.breakLinesInConsole();
    }

}
