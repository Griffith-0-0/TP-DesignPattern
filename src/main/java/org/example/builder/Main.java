package org.example.builder;

public class Main {

    public static void main(String[] args) {

        BankAccountDirector director = new BankAccountDirector();

        System.out.println("=== TESTS DU PATTERN BUILDER AVEC DIRECTOR ===\n");

        // Test 1 : Compte standard avec Director
        System.out.println("1. Compte standard :");
        CurrentAccount standard = director.createStandardAccount("Alice", 1500.0);
        System.out.println(standard);
        System.out.println();

        // Test 2 : Compte premium avec Director
        System.out.println("2. Compte premium :");
        CurrentAccount premium = director.createPremiumAccount("Bob", 10000.0);
        System.out.println(premium);
        System.out.println();

        // Test 3 : Compte épargne avec Director
        System.out.println("3. Compte épargne :");
        SavingsAccount savings = director.createStandardSavingsAccount("Claire", 5000.0);
        System.out.println(savings);
        System.out.println();

        // Test 4 : Compte retraite avec Director
        System.out.println("4. Compte retraite :");
        SavingsAccount retirement = director.createRetirementAccount("David", 45, 25000.0);
        System.out.println(retirement);
        System.out.println();

        // Test 5 : Compte personnalisé sans Director
        System.out.println("5. Compte personnalisé (sans Director) :");
        CurrentAccount custom = new CurrentAccount.CurrentAccountBuilder()
                .accountNumber("CUSTOM-001")
                .ownerName("Emma")
                .balance(3000.0)
                .currency("USD")
                .overdraft(1000.0)
                .accountType("VIP")
                .build();
        System.out.println(custom);
        System.out.println();

        // Test 6 : Gestion d'erreur
        System.out.println("6. Test erreur (premium sans dépôt minimum) :");
        try {
            director.createPremiumAccount("Jean", 1000.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}