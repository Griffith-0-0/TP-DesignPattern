package org.example.decorator.deco;

import org.example.decorator.Panachi;

public class Banane extends Decorator {

    public Banane(Panachi panachi) {
        super(panachi);
    }

    @Override
    public String getDescription() {
        return panachi.getDescription() + " banane";
    }

    @Override
    public Double cout() {
        return 4+panachi.cout();
    }
}
