package org.example.decorator.deco;

import org.example.decorator.Panachi;

public class Fraise extends Decorator {

    public Fraise(Panachi panachi) {
        super(panachi);
    }

    @Override
    public String getDescription() {
        return panachi.getDescription() + " fraise";
    }

    @Override
    public Double cout() {
        return 5+panachi.cout();
    }
}
