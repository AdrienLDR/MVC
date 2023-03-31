package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.SpellModel;

public class SpellView {

    private Scanner scanner;
    SpellModel spellModel = new SpellModel("","",0,0);


    public SpellView() {
        scanner = new Scanner(System.in);
    }

    public static void displaySpells() {
        System.out.println("List of spells:");
        for (SpellModel spell : SpellModel.getAvailableSpells()) {
            System.out.println(spell.getName() + " - " + spell.getEffect() + " (Damage: " + spell.getDamage() + ", Mana cost: " + spell.getManaCost() + ")");
        }
    }

    public void displayKnownSpells(List<SpellModel> knownSpells) {
        System.out.println("Known spells:");

        for (SpellModel spell :spellModel.getKnownSpells()
) {
            System.out.println(spell.getName() + " - " + spell.getEffect() + " (Damage: " + spell.getDamage() + ", Mana cost: " + spell.getManaCost() + ")");
        }
    }

    public String askSpell(List<SpellModel> knownSpells) {
        System.out.println("Please enter the name of the spell you want to cast: ");
        String spellName = scanner.nextLine();

        for (SpellModel knownSpell : knownSpells) {
            if (knownSpell.getName().equalsIgnoreCase(spellName)) {
                return knownSpell.getName(); // retourne le nom du sort connu
            }
        }
        return null; // retourne null si le sort n'a pas été trouvé
    }

    public void displayInvalidSpell() {
        System.out.println("Invalid spell!");
    }

    public void displayInsufficientMana() {
        System.out.println("You don't have enough mana to cast this spell!");
    }

    public void displayCastSpell(String spellName, int damage) {
        System.out.println("You cast " + spellName + " for " + damage + " damage!");
    }

}