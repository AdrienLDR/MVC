package View;

import java.util.List;
import java.util.Scanner;

import Model.SpellModel;

public class WizardView {
    private static final Scanner scanner = new Scanner(System.in);
    SpellModel spellModel = new SpellModel("","",0,0);


    public static String askForName() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        return name;
    }

    public static void display(String name, int health, int mana, int experience, String houseName, String petName, String petSpecies, String wandWood, String wandCore, int wandLength) {
        Display.displayWizardInfo(name, health, mana, experience);
        Display.displayHouseInfo(houseName);
        Display.displayPetInfo(petName, petSpecies);
        Display.displayWandInfo(wandWood, wandCore, wandLength);

        SpellModel spellModel = new SpellModel("","",0,0);
        List<SpellModel> knownSpells = spellModel.getKnownSpells();
        SpellView spellView = new SpellView();
        spellView.displayKnownSpells(knownSpells);
    }

}
