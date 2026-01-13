package org.example.Singleton;

public class Configuration {
    // volatile pour garantir la visibilité entre threads
    private static volatile Configuration instance;

    private String appName;
    private String version;
    private int maxConnections;

    // Constructeur privé
    private Configuration() {
        this.appName = "MyApp";
        this.version = "1.0.0";
        this.maxConnections = 100;
        System.out.println("Configuration chargée");
    }

    // Double-checked locking pour thread-safety et performance
    public static Configuration getInstance() {
        if (instance == null) {
            synchronized (Configuration.class) {
                if (instance == null) {
                    instance = new Configuration();
                }
            }
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void displayConfig() {
        System.out.println("Application: " + appName);
        System.out.println("Version: " + version);
        System.out.println("Max Connections: " + maxConnections);
    }
}  
