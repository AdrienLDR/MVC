package View;

import Model.WandModel;

import java.util.Scanner;

public class WandView {
    private static Scanner scanner = new Scanner(System.in);

    public static String chooseWood() {
        System.out.println("Comment te decris-tu ?: \n1) Créatif \n2) Curieux \n3) Discret \n4) Dynamique ");
        int choix = scanner.nextInt();

        if (choix == 1) {
            return "de Vigne";
        } else if (choix == 2) {
            return "d'Acacia";
        } else if (choix == 3) {
            return "d'Aulne";
        } else if (choix == 4) {
            return "de Bouleau";
        } else {
            System.out.println("Choix invalide !");
            return null;
        }
    }

    public static String chooseCore() {
        System.out.println("Tu penses etre plus?:\n1) Patient \n2) Sensible \n3) Attentif \n4) Fiable ");
        int choix = scanner.nextInt();
        if (choix == 1) {
            return "en Crin de Licorne.";
        } else if (choix == 2) {
            return "en Ventricule de dragon.";
        } else if (choix == 3) {
            return "en Plume de Phoenix.";
        } else if (choix == 4) {
            return "avec un cheveu de Vélane.";
        } else {
            System.out.println("Choix invalide !");
            return null;
        }
    }

    public static void displayWandInfo(String name, WandModel wand) {
        System.out.println("Félicitations " + name + ", tu as choisi une baguette en " + wand.getWood() + ", mesure " + wand.getLength() + "cm et a un cœur " + wand.getCore() + ".");
    }

}
