package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.DoloresOmbrageModel;
import View.*;

import java.util.List;
import java.util.Scanner;

public class Level5 {
    static List<SpellModel> knownSpells = SpellModel.getAvailableSpells();
    static String attack = AttackModel.getOmbrageAttacks().toString();

    public static void level5(WizardModel wizard, EnemyModel enemy) {
        wizard.getHealth();
        DoloresOmbrageModel ombrageModel = new DoloresOmbrageModel("Dolores Ombrage", 250, AttackModel.getOmbrageAttacks(), wizard);
        ombrageModel.getHealth();
        ombrageModel.getVisibility();
        int feuxDartifice = 0;
        SpellModel reducto;
        System.out.println("Vous êtes dans la salle d'examen de Poudlard, prêt à passer votre BUSE (Brevet Universel de Sorcellerie Élémentaire) ! Cependant, Dolores Ombrage veille sur le grain et sera un obstacle sur votre chemin. Votre objectif est de la distraire le temps que les feux d'artifice soient prêts à être utilisés.");

        System.out.println("Vous vous préparez à affronter Dolores Ombrage avec votre baguette magique en main.");
        SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());

        while (wizard.getHealth() > 0 && ombrageModel.getHealth() > 0) {
            Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
            Display.displayEnemyInfo(enemy);
            Scanner scanner = new Scanner(System.in);
            // Le wizard choisit son action
            System.out.println("Que voulez-vous faire ? \n1 attaquer\n2 se cacher\n3 Observer la pièce.");
            int choix = scanner.nextInt();
            if (choix == 1) {
                spellController.askSpellAndCast(ombrageModel);
            } else if (choix == 2) {
                PotionController potionController = new PotionController();
                potionController.useHidePotion(wizard);
                wizard.getHealth();
            } else if (choix == 3) {
                // Observation de la piece
                if (ombrageModel.getVisibility() < 1) {
                    System.out.println("Vous n'y voyez pas assez, vous devriez vous éclairer les idées !");
                } else {
                    System.out.println("Vous distinguez des formes dans la pièce, qu'est-ce qui vous intéresse ?");
                    System.out.println("1) Un tiroir");
                    System.out.println("2) Un livre");
                    System.out.println("3) Un parchemin");

                    int objet = scanner.nextInt();
                    if (objet == 1) {
                        System.out.println("Vous avez trouvé des pétards et vous vous emparez des feux d'artifice !");
                        feuxDartifice++;
                        if (feuxDartifice == 3) {
                            System.out.println("Vous avez maintenant suffisamment de feux d'artifice pour mettre en place votre distraction !");
                            reducto = spellController.getSpell("Reducto");
                            reducto.setDamage(150);
                        }
                    } else if (objet == 2) {
                        ItemController itemController = new ItemController();
                        itemController.useBookItem(wizard, ombrageModel, ombrageModel.getVisibility());
                    } else if (objet == 3) {
                        itemController = new ItemController();
                        itemController.useParchmentItem(wizard, ombrageModel);
                    }
                }
            }        // Ombrage choisit son action
            int ombrageAction = (int) (Math.random() * 2);
            if (ombrageAction == 0) {
                System.out.println("Dolores Ombrage lance une attaque !");
                ombrageModel.attack(wizard);
            } else {
                System.out.println("Dolores Ombrage se défend.");
            }

            // Si les feux d'artifice sont prêts, le joueur peut les utiliser pour distraire Ombrage
            if (feuxDartifice == 3) {
                System.out.println("Les feux d'artifice sont prêts ! Voulez-vous les utiliser pour distraire Dolores Ombrage ? (y/n)");
                String distractionChoice = scanner.next();
                if (distractionChoice.equals("y")) {
                    System.out.println("Vous utilisez les feux d'artifice pour distraire Dolores Ombrage !");
                    reducto.castSpell(ombrageModel);
                    feuxDartifice = 0;
                }
            }
        }

        if (wizard.getHealth() > 0) {
            System.out.println("Félicitations, vous avez réussi à distraire Dolores Ombrage et à passer votre BUSE !");
        } else {
            System.out.println("Vous avez échoué à passer votre BUSE, vous allez devoir retenter votre chance...");
        }
    }
}
