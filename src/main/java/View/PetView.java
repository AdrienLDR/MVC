package View;

import java.util.Scanner;

public class PetView {
    public static void displayWelcome() {
        System.out.println("Bienvenue dans le monde des animaux de compagnie dans Harry Potter!");
    }
    public static void displayQualitOptions() {
        System.out.println("Quelle est votre qualité principale?");
        System.out.println("1. Intelligence");
        System.out.println("2. Fidélité");
        System.out.println("3. Courage");
    }

    public static void displayQualityOptions() {
        System.out.println("Quel est votre animal de compagnie préféré?");
        System.out.println("1. Hibou");
        System.out.println("2. Chien");
        System.out.println("3. Chat");
    }

    public static void displayAskName() {
        System.out.println("Quel est le nom de votre animal de compagnie?");
    }

    public static void displayInvalidQuality() {
        System.out.println("Je suis désolé, cette qualité n'est pas valide.");
    }

    public static void display(String name, String species) {
        System.out.println("Votre animal de compagnie s'appelle " + name + " et c'est un " + species + ".");
    }

    public static int getQualityChoice() {
        Scanner scanner = new Scanner(System.in);
        int choixQualite = scanner.nextInt();
        return choixQualite;
    }

    public static int getAnimalChoice() {
        Scanner scanner = new Scanner(System.in);
        int choixEspece = scanner.nextInt();
        return choixEspece;
    }

    public static int getNameChoice() {
        Scanner scanner = new Scanner(System.in);
        int choixNom = scanner.nextInt();
        return choixNom;
    }

    public static String getPetName() {
        Scanner scanner = new Scanner(System.in);
        String nomAnimal = scanner.next();
        return nomAnimal;
    }

    public static void displayInvalidAnimal() {
        System.out.println("Je suis désolé, l'espèce n'est pas valide.");
    }

}
