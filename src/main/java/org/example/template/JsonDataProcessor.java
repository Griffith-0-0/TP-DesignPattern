package org.example.template;

public class JsonDataProcessor extends DataProcessor {

    @Override
    protected void validateData() {
        System.out.println("Validating JSON structure...");
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing JSON objects...");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving to JSON file...");
    }
}

