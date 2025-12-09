package org.example.proxy;

public class Test {
    public static void main(String[] args) {
        // Création du proxy sécurisé avec cache
        var securedCache = new SecuredCache();
        securedCache.setPassword(1234); // Définir le mot de passe correct

        // Injection du proxy dans le client (pas UserImpl directement!)
        Client client = new Client();
        client.setUser(securedCache); // Utiliser le proxy

        System.out.println("=== Test avec le bon mot de passe ===");
        client.recupererPIN(1767);
        client.recupererPIN(1767); // Devrait utiliser le cache
        client.recupererPIN(2024);
        client.recupererPIN(1767); // Devrait utiliser le cache

        System.out.println("\n=== Test avec un mauvais mot de passe ===");
        securedCache.setPassword(9999); // Mauvais mot de passe
        try {
            client.recupererPIN(3000);
        } catch (RuntimeException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}
