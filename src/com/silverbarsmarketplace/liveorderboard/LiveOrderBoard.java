package com.silverbarsmarketplace.liveorderboard;

import java.util.Scanner;

/**
 * Created by parisfreire on 21/02/2019.
 */
public class LiveOrderBoard {

    //Register order
    //Cancel order
    //Summary information orders

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
                breakLinesInConsole();
                // register order
                break;

            case 2 :
                breakLinesInConsole();
                // cancel order
                break; // optional

            case 3 :
                breakLinesInConsole();
                break; // optional

            case 4 :
                System.out.println("Quitting application...");
                break; // optional

            default :
                System.out.println("Wrong option. Please try again.");
                breakLinesInConsole();
        }
    }

    private static void breakLinesInConsole(){
        for (int i = 0; i < 3; ++i) System.out.println("-------------------7");
    }

}
