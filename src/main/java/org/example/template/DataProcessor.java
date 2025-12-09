package org.example.template;

public abstract class DataProcessor {

    // Template method - définit le squelette de l'algorithme
    public final void process() {
        loadData();
        validateData();
        parseData();
        saveData();
        cleanup();
    }

    // Étapes communes avec implémentation par défaut
    protected void loadData() {
        System.out.println("Loading data...");
    }

    protected void cleanup() {
        System.out.println("Cleaning up resources...");
    }

    // Étapes abstraites - doivent être implémentées par les sous-classes
    protected abstract void validateData();
    protected abstract void parseData();
    protected abstract void saveData();
}

