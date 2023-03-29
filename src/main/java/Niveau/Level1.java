package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.TrollModel;
import View.*;

import java.util.List;
import java.util.Scanner;


public class Level1 {

    static List<SpellModel> knownSpells = SpellModel.getAvailableSpells();

    public static void level1(WizardModel wizard, EnemyModel enemy) {
        // Initialisation des variables du wizard
        int wizardVisibility = wizard.getVisibility();
        int wizardHealth = wizard.getHealth();

        // Initialisation des variables du troll
        TrollModel trollModel = new TrollModel("Troll", 120, AttackModel.getTrollAttacks());
        int trollHealth = trollModel.getHealth();
        int trollVisibility = trollModel.getVisibility();
        int lavabo = 0;

        System.out.println("Vous êtes maintenant dans les toilettes du château. Vous entendez un bruit bizarre venant de l'une des cabines. En vous approchant, vous remarquez qu'un énorme troll est en train de détruire tout sur son passage.");

        System.out.println("Le troll vous voit et s'approche de vous en hurlant. Vous sortez votre baguette magique et vous vous préparez à l'affronter avec le peu de connaissances que vous avez!.");
        while (wizard.getHealth() > 0 && trollModel.getHealth() > 0) {

            Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
            Display.displayEnemyInfo(enemy);

            Scanner scanner = new Scanner(System.in);
            // Le wizard choisit son action
            System.out.println("Que voulez-vous faire ? \n1 attaquer\n2 se cacher\n3 Observer la pièce.");

            int choix = scanner.nextInt();
            if (choix == 1) {
                SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());
                spellController.askSpellAndCast(enemy);

            } else if (choix == 2) {
                PotionController potionController = new PotionController();
                potionController.useHidePotion(wizard);
                // Corriger les dégâts infligés au wizard
                wizardHealth = wizard.getHealth();
            } else if (choix == 3) {
                // Observation de la piece
                if (trollModel.getVisibility() < 1) {
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
                        itemController.useLavatoryItem(wizard, (TrollModel) enemy, lavabo, TrollModel.getVisibility());
                        // Corriger les dégâts infligés au wizard et à l'ennemi
                        trollHealth = enemy.getHealth();
                        wizardHealth = wizard.getHealth();
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