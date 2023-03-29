package View;

import Model.Enemy.TrollModel;
import Model.EnemyModel;

public class Display {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static void displayWizardInfo(String name, int health, int mana, int experience) {
        System.out.println(YELLOW + "-----------------------------------------------");
        System.out.print(PURPLE + "Wizard: " + name + "\t");
        System.out.print(RED + "Health: " + RED + health + "\t");
        System.out.print(BLUE + "Mana: " + BLUE + mana + "\t");
        System.out.println(YELLOW + "Experience: " + YELLOW + experience);
        System.out.println(YELLOW + "-----------------------------------------------" + RESET);
    }

    public static void displayHouseInfo(String houseName) {
        String color = "";
        switch (houseName) {
            case "Gryffindor":
                color = RED;
                break;
            case "Hufflepuff":
                color = YELLOW;
                break;
            case "Ravenclaw":
                color = BLUE;
                break;
            case "Slytherin":
                color = GREEN;
                break;
            default:
                color = RESET;
                break;
        }
        System.out.println(color + "-----------------------------------------------");
        System.out.println(PURPLE + "House: " + houseName);
        System.out.println(color + "-----------------------------------------------" + RESET);
    }


    public static void displayPetInfo(String petName, String petSpecies) {
        System.out.println(YELLOW + "-----------------------------------------------");
        System.out.println(PURPLE + "Pet: " + CYAN + petName + RESET + " (" + CYAN + petSpecies + RESET + ")");
        System.out.println(YELLOW + "-----------------------------------------------" + RESET);
    }

    public static void displayWandInfo(String wandWood, String wandCore, int wandLength) {
        System.out.println(YELLOW + "-----------------------------------------------");
        System.out.println(PURPLE + "Wand: " + CYAN + "Bois " + wandWood + RESET + " avec un coeur en " + CYAN + wandCore + RESET + " et de " + CYAN + wandLength + " cm." + RESET);
        System.out.println(YELLOW + "-----------------------------------------------" + RESET);
    }

    public static void displayEnemyInfo(EnemyModel enemy) {
        System.out.println(YELLOW + "-----------------------------------------------");
        System.out.print(PURPLE + "Enemy: " + enemy.getName() + "\t");
        System.out.print(RED + "Health: " + RED + enemy.getHealth() + "\t");

        if (enemy instanceof TrollModel) {
            System.out.println(GREEN + "Visibility: " + ((TrollModel) enemy).getVisibility() + "\t");
        }

        System.out.println(YELLOW + "-----------------------------------------------" + RESET);
    }

    public static void displayEnemyNoDamage(String enemyName) {
        System.out.println(RED + enemyName + " a infligé aucun dégât." + RESET);
    }

}