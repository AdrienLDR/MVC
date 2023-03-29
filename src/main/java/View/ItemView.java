package View;

import Model.Enemy.TrollModel;
import Model.EnemyModel;

public class ItemView {
    public void displayLavatoryItem() {
        System.out.println("Vous voyez une éponge et un savon dans le lavabo.");
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1. Utiliser l'éponge pour nettoyer le sol.");
        System.out.println("2. Utiliser le savon pour faire glisser le troll.");
    }

    public void displayCleaningResult() {
        System.out.println("Vous nettoyez le sol. Le troll est momentanément déstabilisé !");
        System.out.println("Cela te donne l'idée de lui fracasser le crane avec le lavabo");

    }

    public void displaySlipperyResult() {
        System.out.println("Vous enduisez le sol de savon. Le troll glisse et tombe à terre !");
    }

    public void displayTrollHealth() {
        System.out.println("Le troll a perdu 4 points de vie !");
        System.out.println("Cela te donne l'idée de lui fracasser le crane avec le lavabo");

    }

    public void displayInvalidAction() {
        System.out.println("Action invalide !");
    }
}
