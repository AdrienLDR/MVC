package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.DementorModel;
import View.*;

import java.util.List;
import java.util.Scanner;

public class Level3 {
    static List<SpellModel> knownSpells = SpellModel.getAvailableSpells();
    static String attack = AttackModel.getDementorAttacks().toString();

    public static void level3(WizardModel wizard, EnemyModel enemy) {
        wizard.getHealth();
        DementorModel dementorModel = new DementorModel("Dementor", 150, AttackModel.getDementorAttacks(), wizard);
        dementorModel.getHealth();
        dementorModel.getVisibility();
        int forest = 0;
        SpellModel expectoPatronum;
        System.out.println("Vous êtes dans la forêt interdite. Vous entendez des cris et des pleurs, et vous voyez des ombres s'approcher de vous. Ce sont les Détraqueurs, et ils sont très dangereux.");

        System.out.println("Les Détraqueurs se rapprochent de vous, et vous commencez à sentir leur souffle glacé sur votre visage. Vous sortez votre baguette magique et vous vous préparez à l'affronter.");
        SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());

        while (wizard.getHealth() > 0 && dementorModel.getHealth() > 0) {
            Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
            Display.displayEnemyInfo(enemy);
            Scanner scanner = new Scanner(System.in);
            // Le wizard choisit son action
            System.out.println("Que voulez-vous faire ? \n1 attaquer\n2 se cacher\n3 Observer la forêt.");
            int choix = scanner.nextInt();
            if (choix == 1) {
                expectoPatronum = spellController.getSpell("Expecto Patronum");
                expectoPatronum.setDamage(80);
                spellController.castSpell(expectoPatronum, dementorModel);
            } else if (choix == 2) {
                PotionController potionController = new PotionController();
                potionController.useHidePotion(wizard);
                // Corriger les dégâts infligés au wizard
                wizard.getHealth();
            } else if (choix == 3) {
                // Observation de la forêt
                if (dementorModel.getVisibility() < 1) {
                    System.out.println("Vous n'arrivez pas à voir à travers le brouillard épais.");
                } else {
                    System.out.println("Vous observez la forêt et vous remarquez quelque chose d'intéressant.");
                    System.out.println("1) Une source de lumière");
                    System.out.println("2) Un arbre étrange");
                    System.out.println("3) Une clairière");

                    int objet = scanner.nextInt();
                    if (objet == 1) {
                        System.out.println("Vous remarquez une lumière brillante au loin.");
                    } else if (objet == 2) {
                        ItemController itemController = new ItemController();
                        itemController.useForestItem(wizard, (DementorModel) enemy, forest, dementorModel.getVisibility());
                        // Corriger les dégâts infligés au wizard et à l'ennemi
                    } else if (objet == 3) {
                    System.out.println("Vous voyez une clairière au loin, mais elle semble dangereuse.");
                    System.out.println("Voulez-vous y aller ? \n1 oui\n2 non");
                    int response = scanner.nextInt();
                    if (response == 1) {
// Accès à la clairière
                        System.out.println("Vous entrez dans la clairière et vous voyez un objet brillant au sol.");
                        System.out.println("1) Ramasser l'objet");
                        System.out.println("2) Rester sur vos gardes");
                        int action = scanner.nextInt();
                        if (action == 1) {
                            System.out.println("Vous ramassez l'objet et vous vous rendez compte qu'il s'agit d'une potion de guérison.");
                            PotionController potionController = new PotionController();
                            potionController.useHealingPotion(wizard);
                        } else if (action == 2) {
                            System.out.println("Vous restez sur vos gardes et vous observez les alentours.");
                        }
                    } else if (response == 2) {
                        System.out.println("Vous décidez de ne pas prendre de risques et vous restez dans la forêt.");
                    }
                }
            }
        }
        if (dementorModel.getHealth() > 0) {
// Attaque du dementor si il n'est pas vaincu
            dementorModel.attack(wizard);
        }
    }
if (wizard.getHealth() > 0) {
        System.out.println("Vous avez vaincu le Dementor !");
        wizard.setExperience(wizard.getExperience() + 50);
    } else {
        System.out.println("Vous avez été vaincu par le Dementor...");
    }
}
}