package edu.wctc.dice.impl;

import edu.wctc.dice.Sale;
import edu.wctc.dice.iface.GameInput;
import edu.wctc.dice.iface.SalesInput;
import edu.wctc.dice.iface.SalesReport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ConsoleInput implements SalesInput {
    private Scanner scanner = new Scanner(System.in);

//
//    @Override
//    public String getInput(String prompt) {
//        System.out.print(prompt);
//        return scanner.nextLine();
//    }

    @Override
    public List<Sale> getSales() {
        String input = "";
        List<Sale> salesList = new ArrayList<>();

        while(!input.equalsIgnoreCase("q")) {
            System.out.println("Enter sales information as customer name, country, amount, tax; Enter q to quit");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                return salesList;
            } else {

                String array[] = input.split(",");
                Sale sale = new Sale(array);
                salesList.add(sale);
            }
        }
        return salesList;
    }
}
