package org.example.template;

public class CsvDataProcessor extends DataProcessor {

    @Override
    protected void validateData() {
        System.out.println("Validating CSV format...");
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing CSV rows and columns...");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving to CSV file...");
    }
}

