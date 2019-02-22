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
        System.out.println("#################### \n");


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
        System.out.println("3. Summary \n");
        System.out.println("-------------------");
        System.out.println("4. EXIT");
        System.out.println("------------------- \n");

        System.out.println("> Enter your option and hit Enter: ");
    }

    private static void displayOptionSelected(short option){
        switch(option) {
            case 1 :
                Utils.breakLinesInConsole();

                registerOrder();

                // register order
                break;

            case 2 :
                Utils.breakLinesInConsole();
                // cancel order
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

    private static Order registerOrder(){

        Order order = null;
        Scanner sc2 = new Scanner(System.in);

        System.out.println("> Is it going to be a BUY or a SELL?: (B/S)");

        char orderType = sc2.next().charAt(0);
        int userId, pricePerKg;
        double orderQuantity;


        if(orderType == 'B' || orderType == 'b'){

            System.out.println("> Enter your user id: ");
            userId = sc2.nextInt();
            System.out.println("> Enter your order quantity: ");
            orderQuantity = sc2.nextDouble();
            System.out.println("> Enter your price per Kg: ");
            pricePerKg = sc2.nextInt();

            Utils.breakLinesInConsole();

            order = new Buy(userId, pricePerKg, orderQuantity);
            updateBuysList(order);

        }else if(orderType == 'S' || orderType == 's'){

            System.out.println("> Enter your user id: ");
            userId = sc2.nextInt();
            System.out.println("> Enter your order quantity: ");
            orderQuantity = sc2.nextDouble();
            System.out.println("> Enter your price per Kg: ");
            pricePerKg = sc2.nextInt();

            order = new Sell(userId, pricePerKg, orderQuantity);
            updateSellsList(order);

        }else{
            System.out.println("> Incorrect order. Please try again.");

            registerOrder();
        }

        return order;
    }

    private static void updateBuysList(Order order){

        buysList.add(order);

        Comparator comparatorByPriceReversed = order.getComparatorByPriceReversed();
        Collections.sort(buysList, comparatorByPriceReversed);
    }

    private static void updateSellsList(Order order){

        sellsList.add(order);

        Comparator comparatorByPrice = order.getComparatorByPrice();
        Collections.sort(buysList, comparatorByPrice);
    }


    private static void ordersSummary(){
        System.out.println("Summary information of live orders \n");

        for (Order sell : sellsList) {
            System.out.println("SELL: "+ sell.getOrderQuantity() + "kg for £"+ sell.getPricePerKg() + "[user" +sell.getUserId()+"]" );
        }

        for (Order buy : buysList) {
            System.out.println("BUY: "+ buy.getOrderQuantity() + "kg for £"+ buy.getPricePerKg() + "[user" +buy.getUserId()+"]" );
        }

        Utils.breakLinesInConsole();
    }

}
