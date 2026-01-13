package org.example.Prototype;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== PATTERN PROTOTYPE - DOCUMENT ===\n");

        // Création du document original
        System.out.println("1. Création du document original :");
        Document original = new Document(
                "Rapport annuel 2024",
                "Contenu du rapport financier...",
                "Jean Dupont"
        );
        System.out.println(original);
        System.out.println();

        // Clonage pour créer une variante
        System.out.println("2. Clonage pour Q1 :");
        Document rapportQ1 = original.clone();
        rapportQ1.setTitle("Rapport Q1 2024");
        rapportQ1.setContent("Contenu spécifique Q1...");
        System.out.println(rapportQ1);
        System.out.println();

        // Clonage pour créer une autre variante
        System.out.println("3. Clonage pour Q2 :");
        Document rapportQ2 = original.clone();
        rapportQ2.setTitle("Rapport Q2 2024");
        rapportQ2.setContent("Contenu spécifique Q2...");
        System.out.println(rapportQ2);
        System.out.println();

        // Vérification que l'original n'a pas changé
        System.out.println("4. Document original (non modifié) :");
        System.out.println(original);
        System.out.println();

        // Vérification que ce sont des objets différents
        System.out.println("5. Vérification des références :");
        System.out.println("original == rapportQ1 ? " + (original == rapportQ1));
        System.out.println("original == rapportQ2 ? " + (original == rapportQ2));
        System.out.println("rapportQ1 == rapportQ2 ? " + (rapportQ1 == rapportQ2));
    }
}
