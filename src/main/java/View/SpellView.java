package View;

import java.util.Scanner;

import Model.SpellModel;

public class SpellView {

    private final Scanner scanner;
    private SpellModel[] spells;

    public SpellView() {
        scanner = new Scanner(System.in);
    }

    public void displaySpells() {
        System.out.println("List of spells:");
        for (SpellModel spell : spells) {
            System.out.println(spell.getName() + " - " + spell.getEffect() + " (Damage: " + spell.getDamage() + ", Mana cost: " + spell.getManaCost() + ")");
        }
    }

    public String askSpell() {
        System.out.print("Enter the name of the spell to cast: ");
        return scanner.nextLine();
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
