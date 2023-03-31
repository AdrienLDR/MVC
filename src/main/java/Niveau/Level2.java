package Niveau;

import Model.*;
import View.Display;
import Controller.PotionController;
import Controller.RewardController;
import Controller.SpellController;
import Model.Enemy.BasiliskModel;
import View.SpellView;

import java.util.List;
import java.util.Scanner;

public class Level2 {
    static List<SpellModel> knownSpells = SpellModel.getAvailableSpells();

    static String attack = AttackModel.getBasiliskAttacks().toString();

    public static void level2(WizardModel wizard, EnemyModel enemy) {

        Display display = new Display();

        wizard.getHealth();
        BasiliskModel basiliskModel = new BasiliskModel("Basilisk", 200, AttackModel.getBasiliskAttacks(), wizard);
        basiliskModel.getHealth();

        knownSpells.add(new SpellModel("Accio", "Sortilège d'Attraction", 30, 20));

        boolean hasSword = WizardModel.House.GRYFFINDOR.equals(wizard.getHouse());
        boolean hasTooth = false;

        System.out.println("Vous êtes maintenant dans la Chambre des Secrets. Vous êtes face au terrible basilic !");

        SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());

        while (wizard.getHealth() > 0 && basiliskModel.getHealth() > 0) {

            Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
            display.displayEnemyInfo(basiliskModel);
            Scanner scanner = new Scanner(System.in);

            // Le wizard choisit son action
            System.out.println("Que voulez-vous faire ? ");
            System.out.println("1 attaquer");
            System.out.println("2 utiliser une potion");
            System.out.println("3 Utiliser vos objets");

            int choix = scanner.nextInt();

            if (choix == 1) {
                spellController.askSpellAndCast(basiliskModel);

                if (hasSword) {
                    System.out.println("Vous utilisez l'épée légendaire de Godric Gryffindor pour terrasser le basilic !");
                    basiliskModel.takeDamage(150);
                } else if (hasTooth) {
                    System.out.println("Vous utilisez le croc du basilic pour détruire le journal de Tom Jedusor !");
                    wizard.getInventory().remove("Croc du basilic");
                    basiliskModel.takeDamage(100);
                }
            } else if (choix == 2) {
                PotionController potionController = new PotionController();
                potionController.useHidePotion(wizard);
                // Afficher les dégâts infligés au wizard
                System.out.println("Vous avez récupéré 50 points de vie !");
                Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
            } else if (choix == 3) {


                // Recuperation crocs
                System.out.println("qu'est-ce qui vous intéresse ?");
                System.out.println("1) L'épée légendaire de Godric Gryffindor");
                System.out.println("2) Les crocs du basilic");

                int objet = scanner.nextInt();
                if (objet == 1 && !hasSword) {
                    System.out.println("Vous êtes equipé de l'épée légendaire de Godric Gryffindor !");
                    hasSword = true;
                } else if (objet == 2 && !hasTooth) {
                    System.out.println("Vous n'avez pas de crocs de Basilic, essayer de lui en arracher un !");
                    hasTooth = true;
                } else if (objet == 2) {
                    System.out.println("Vous avez déjà récupéré un croc du basilic! Il ne reste plus qu'a detruire le journal.");
                } else {
                    System.out.println("Objet invalide.");
                    continue;
                }
            }
            enemy.attack(attack, enemy);
            if (wizard.getHealth() <= 0) {
                System.out.println("Vous êtes mort...");
            } else if (basiliskModel.getHealth() <= 0) {
                if (hasTooth) {
                    System.out.println("Vous avez vaincu le basilic en utilisant le croc du basilic !");
                    RewardController.giveRewardToWizard(wizard);
                } else if (hasSword) {
                    System.out.println("Vous avez vaincu le basilic en utilisant l'épée légendaire de Godric Gryffindor !");
                    RewardController.giveRewardToWizard(wizard);
                } else {
                    System.out.println("Vous avez vaincu le basilic !");
                    RewardController.giveRewardToWizard(wizard);
                }
            }
            Level3.level3(wizard, new EnemyModel("Dementor", 150, AttackModel.getDementorAttacks(), wizard));
        }
    }
}