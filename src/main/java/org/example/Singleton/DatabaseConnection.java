package org.example.Singleton;


// Singleton Simple - Eager Initialization
public class DatabaseConnection {
    // instance crée au chargement de la classe
    private static DatabaseConnection instance=new DatabaseConnection();

    private String connectionUrl;
    private boolean isConnected;

    // privé pour empecher l'instanciation
    private DatabaseConnection() {
        this.connectionUrl = "jdbc:mysql://localhost:3306/mydb";
    }
    public static DatabaseConnection getInstance() {
        return  instance;
    }
    public void connect() {
        if (!isConnected) {
            isConnected = true;
            System.out.println("Connexion établie à " + connectionUrl);
        } else {
            System.out.println("Déjà connecté");

        }
    }
    public void disconnect() {
        if (isConnected) {
            isConnected = false;
            System.out.println("Connexion fermée");
        }
    }

    public boolean isConnected() {
        return isConnected;
    }
}
