package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.TrollModel;
import View.*;

import java.util.List;
import java.util.Scanner;

public class level1 {
    private static WizardModel wizard;
    private static TrollModel troll;
    private static List<SpellModel> knownSpells;

    public static void level1() {
        wizard = wizard;
        troll = troll;
        knownSpells = knownSpells;

        // Initialisation des variables du wizard
        int visibilityWizard = wizard.getVisibility();

        // Initialisation des variables du troll
        int vieTroll = troll.getHealth();
        int visibilityTroll = troll.getVisibility();

        int lavabo = 0;
        System.out.println("Vous êtes maintenant dans les toilettes du château. Vous entendez un bruit bizarre venant de l'une des cabines. En vous approchant, vous remarquez qu'un énorme troll est en train de détruire tout sur son passage.");

        System.out.println("Le troll vous voit et s'approche de vous en hurlant. Vous sortez votre baguette magique et vous vous préparez à l'affronter avec le peu de connaissance que vous avez!.");

        Scanner scanner = new Scanner(System.in);
        while (wizard.getHealth() > 0 && troll.getHealth() > 0) {
            //demandee d'action qui appelle soit les sort soit les potions
            // Le wizard choisit son action
            System.out.println("Que voulez-vous faire ? \n1 attaquer\n2 se cacher\n3 Observer la piece.");

            int choix = scanner.nextInt();
            if (choix == 1) {
                SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());
                spellController.askSpellAndCast();
            } else if (choix == 2) {
                PotionController potionController = new PotionController();
                potionController.useHidePotion(wizard);
            } else if (choix == 3) {
                // Observation de la piece
                if (visibilityTroll < 1) {
                    System.out.println("Tu n'y vois pas assez, tu devrais t'éclairer les idées !");
                } else {
                    System.out.println("Vous distinguez des formes dans la pièce, qu'est-ce qui vous intéresse ?");
                    System.out.println("1) Une porte");
                    System.out.println("2) Un lavabo");
                    System.out.println("3) Un toilette");

                    int objet = scanner.nextInt();
                    if (objet == 1) {
                        System.out.println("Vous comprenez que vous ne pourrez pas vous enfuir");
                    } else if (objet == 2) {
                        ItemController itemController = new ItemController();
                        itemController.useLavatoryItem(wizard, troll, lavabo, visibilityTroll);
                    } else if (objet == 3) {
                        System.out.println("Vous n'avez pas les capacités de déplacer un tel objet.");
                    } else {
                        System.out.println("Objet invalide.");
                        return;
                    }
                }
            } else {
                System.out.println("Choix invalide.");
                return;
            }
        }
    }
}