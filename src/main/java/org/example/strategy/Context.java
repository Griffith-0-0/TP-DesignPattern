package org.example.strategy;

public class Context {
    private Strategy strategy=new StrategyImpD();

    void effectuerOperation() {
        System.out.println("--------------------");
        strategy.operationStrategy();
        System.out.println("--------------------");
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
