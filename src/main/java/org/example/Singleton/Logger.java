package org.example.Singleton;

public class Logger {
    // Instance non créée au départ
    private static Logger instance;

    private String logFile;

    // Constructeur privé
    private Logger() {
        this.logFile = "application.log";
        System.out.println("Logger initialisé avec le fichier : " + logFile);
    }

    // Création de l'instance seulement quand nécessaire
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message + " -> " + logFile);
    }

    public void error(String message) {
        System.out.println("[ERROR] " + message + " -> " + logFile);
    }

    public void info(String message) {
        System.out.println("[INFO] " + message + " -> " + logFile);
    }
}