package Niveau;

import Model.*;
import View.Display;
import Controller.PotionController;
import Controller.RewardController;
import Controller.SpellController;
import Model.Enemy.BasiliskModel;
import View.HouseView;
import View.SpellView;

import java.util.List;
import java.util.Scanner;

public class Level2 {
    static List<SpellModel> knownSpells = SpellModel.getAvailableSpells();

    static String attack = AttackModel.getBasiliskAttacks().toString();

    public static void level2(WizardModel wizard, EnemyModel enemy) {
        wizard.getHealth();
        BasiliskModel basiliskModel = new BasiliskModel("Basilisk", 200, AttackModel.getBasiliskAttacks(), wizard);
        basiliskModel.getHealth();
        basiliskModel.getVisibility();
        boolean hasSword = WizardModel.House.GRYFFINDOR.equals(wizard.getHouse());
        boolean hasTooth = false;

        System.out.println("Vous êtes maintenant dans la Chambre des Secrets. Vous êtes face au terrible basilic !");

        SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());

        while (wizard.getHealth() > 0 && basiliskModel.getHealth() > 0) {
            Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
            Display.displayEnemyInfo(enemy);
            Scanner scanner = new Scanner(System.in);

            // Le wizard choisit son action
            System.out.println("Que voulez-vous faire ? ");
            System.out.println("1 attaquer");
            System.out.println("2 utiliser une potion");
            System.out.println("3 observer la pièce");

            int choix = scanner.nextInt();

            if (choix == 1) {
                if (hasSword) {
                    System.out.println("Vous utilisez l'épée légendaire de Godric Gryffindor pour terrasser le basilic !");
                    basiliskModel.takeDamage(150);
                } else if (hasTooth) {
                    System.out.println("Vous utilisez le croc du basilic pour détruire le journal de Tom Jedusor !");
                    wizard.getInventory().remove("Croc du basilic");
                    basiliskModel.takeDamage(100);
                } else {
                    spellController.askSpellAndCast(basiliskModel);
                }
            } else if (choix == 2) {
                PotionController potionController = new PotionController();
                potionController.useHidePotion(wizard);
                // Corriger les dégâts infligés au wizard
                wizard.getHealth();
            } else if (choix == 3) {
                // Observation de la piece
                if (basiliskModel.getVisibility() < 1) {
                    System.out.println("Tu n'y vois pas assez, tu devrais t'éclairer les idées !");
                } else {
                    System.out.println("Vous distinguez des formes dans la pièce, qu'est-ce qui vous intéresse ?");
                    System.out.println("1) L'épée légendaire de Godric Gryffindor");
                    System.out.println("2) Les crocs du basilic");

                    int objet = scanner.nextInt();
                    if (objet == 1 && !hasSword) {
                        System.out.println("Vous avez trouvé l'épée légendaire de Godric Gryffindor !");
                        hasSword = true;
                    } else if (objet == 2 && !hasTooth) {
                        System.out.println("Vous avez trouvé un croc du basilic !");
                        hasTooth = true;
                    } else if (objet == 2 && hasTooth) {
                        System.out.println("Vous avez déjà récupéré un croc du basilic !");
                    } else {
                        System.out.println("Objet invalide.");
                        continue;
                    }
                }
                enemy.attack(attack, enemy);
                if (wizard.getHealth() <= 0) {
                    System.out.println("Vous êtes mort...");
                } else if (enemy instanceof BasiliskModel && hasTooth) {
                    System.out.println("Vous avez vaincu le basilic en utilisant le croc du basilic !");
                    RewardController.giveRewardToWizard(wizard);
                } else if (enemy instanceof BasiliskModel && wizard.getHouse().equals(WizardModel.House.GRYFFINDOR) && hasSword) {
                    System.out.println("Vous avez vaincu le basilic en utilisant l'épée légendaire de Godric Gryffindor !");
                    RewardController.giveRewardToWizard(wizard);
                }
            }
        }
    }
}