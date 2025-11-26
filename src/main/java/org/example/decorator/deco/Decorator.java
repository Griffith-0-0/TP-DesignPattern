package org.example.decorator.deco;

import org.example.decorator.Panachi;

public abstract class Decorator extends Panachi {
    protected Panachi panachi;
    public Decorator(Panachi panachi) {
        this.panachi = panachi;
    }



}
