package View;

import java.util.Scanner;

public class PetView {
    public static void displayWelcome() {
        System.out.println("Bienvenue dans le monde des animaux de compagnie dans Harry Potter!");
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


    public static String getPetName() {
        Scanner scanner = new Scanner(System.in);
        String nomAnimal = scanner.next();
        return nomAnimal;
    }

}
