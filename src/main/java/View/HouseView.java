package View;

import Model.WizardModel;

import java.util.Scanner;

public class HouseView {
    private final WizardModel wizardModel;

    public HouseView(WizardModel wizardModel) {
        this.wizardModel = wizardModel;
    }

    public int getHouseChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue " + wizardModel.getName() + " à Poudlard ! Dans quelle maison aimerais-tu être réparti ?");
        System.out.println("1. Gryffondor");
        System.out.println("2. Poufsouffle");
        System.out.println("3. Serdaigle");
        System.out.println("4. Serpentard");
        int choice = scanner.nextInt();
        return choice;
    }

    public void displayHouse(String house) {
        if (house != null) {
            System.out.println("Félicitations " + wizardModel.getName() + ", tu as été réparti dans la maison " + house + " !");
        } else {
            System.out.println("Choix invalide. Tu n'as pas été réparti dans une maison.");
        }
    }
}
