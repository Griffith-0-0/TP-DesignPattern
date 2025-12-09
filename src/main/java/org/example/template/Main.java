package org.example.template;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Processing CSV ===");
        DataProcessor csvProcessor = new CsvDataProcessor();
        csvProcessor.process();

        System.out.println("\n=== Processing JSON ===");
        DataProcessor jsonProcessor = new JsonDataProcessor();
        jsonProcessor.process();
    }
}
