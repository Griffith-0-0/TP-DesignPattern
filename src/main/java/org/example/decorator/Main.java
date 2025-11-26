package org.example.decorator;

import org.example.decorator.deco.Banane;
import org.example.decorator.deco.Fraise;
import org.example.decorator.deco.Khoukh;

public class Main {
    public static void main(String[] args) {
        Panachi panachi;
        panachi= new PanachiLimoun();
        System.out.println(panachi.description);
        System.out.println(panachi.cout());
        System.out.println("------------------------");
        panachi= new Fraise(panachi);
        System.out.println(panachi.getDescription());
        System.out.println(panachi.cout());
        System.out.println("-----------------------");
        panachi= new Khoukh(panachi);
        System.out.println(panachi.getDescription());
        System.out.println(panachi.cout());
        System.out.println("-----------------------");
        panachi= new Banane(panachi);
        System.out.println(panachi.getDescription());
        System.out.println(panachi.cout());
    }
}
