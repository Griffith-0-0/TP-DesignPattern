package org.example.strategy;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Context context = new Context();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("choose strategy");
            String str = scanner.nextLine();
            Strategy strategy = (Strategy) Class.forName("org.example.StrategyImp"+str).newInstance();
            context.setStrategy(strategy);
            context.effectuerOperation();
        }
    }
}