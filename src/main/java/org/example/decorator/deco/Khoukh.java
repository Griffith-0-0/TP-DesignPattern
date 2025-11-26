package org.example.decorator.deco;

import org.example.decorator.Panachi;

public class Khoukh extends Decorator {
    public Khoukh(Panachi panachi) {
        super(panachi);
    }

    @Override
    public String getDescription() {
        return panachi.getDescription()+ " Khoukh";
    }

    @Override
    public Double cout() {
        return 6+panachi.cout();
    }
}
