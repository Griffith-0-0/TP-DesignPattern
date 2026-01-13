package org.example.Singleton;

public class Main {

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║       TEST DES TYPES DE SINGLETONS         ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // =============================================
        // Test 1 : DatabaseConnection (EAGER)
        // =============================================
        System.out.println("--- Test 1 : DatabaseConnection (EAGER) ---");
        System.out.println("Type : Eager Initialization");
        System.out.println("Caractéristique : Instance créée au chargement de la classe\n");

        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("db1 == db2 ? " + (db1 == db2));

        db1.connect();
        db2.connect();
        db1.disconnect();
        System.out.println();

        // =============================================
        // Test 2 : Logger (LAZY)
        // =============================================
        System.out.println("--- Test 2 : Logger (LAZY) ---");
        System.out.println("Type : Lazy Initialization");
        System.out.println("Caractéristique : Instance créée seulement au premier appel\n");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));

        logger1.info("Application démarrée");
        logger2.error("Erreur de test");
        logger1.log("Opération terminée");
        System.out.println();

        // =============================================
        // Test 3 : Configuration (THREAD-SAFE)
        // =============================================
        System.out.println("--- Test 3 : Configuration (THREAD-SAFE) ---");
        System.out.println("Type : Thread-Safe avec Double-Checked Locking");
        System.out.println("Caractéristique : Sûr pour applications multi-threads\n");

        Configuration config1 = Configuration.getInstance();
        Configuration config2 = Configuration.getInstance();

        System.out.println("config1 == config2 ? " + (config1 == config2));

        config1.displayConfig();

        System.out.println("\nModification via config1...");
        config1.setMaxConnections(200);

        System.out.println("Affichage via config2 :");
        config2.displayConfig();

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║            RÉSUMÉ DES TYPES                ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("1. EAGER      : Instance créée immédiatement");
        System.out.println("2. LAZY       : Instance créée à la demande");
        System.out.println("3. THREAD-SAFE: Sécurisé pour multi-threading");
    }
}