package View;

import Model.WizardModel;

import java.util.Scanner;

public class HouseView {
    public static int getHouseChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue " + WizardModel.getName() + " à Poudlard ! Dans quelle maison aimerais-tu être réparti ?");
        System.out.println("1. Gryffondor");
        System.out.println("2. Poufsouffle");
        System.out.println("3. Serdaigle");
        System.out.println("4. Serpentard");
        int choice = scanner.nextInt();
        return choice;
    }

    public static void displayHouse(String house) {
        if (house != null) {
            System.out.println("Félicitations " + WizardModel.getName() + ", tu as été réparti dans la maison " + house + " !");
        } else {
            System.out.println("Choix invalide. Tu n'as pas été réparti dans une maison.");
        }
    }
}
