package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.MangemortModel;
import View.*;

import java.util.List;
import java.util.Scanner;

public class Level6 {static List<SpellModel> knownSpells = SpellModel.getAvailableSpells();
    static String attack = AttackModel.getDeathEaterAttacks().toString();

    public static void level6(WizardModel wizard, EnemyModel enemy) {

        Display display = new Display();

        wizard.getHealth();
        MangemortModel mangemortModel = new MangemortModel("Mangemort", 150, AttackModel.getDeathEaterAttacks(), wizard);
        mangemortModel.getHealth();
        mangemortModel.getVisibility();
        int tourAstronomie = 0;
        SpellModel sectumsempra;

        knownSpells.add(new SpellModel("Sectumsempra", "Sortilège de mutilation", 80, 70));


        System.out.println("Les Mangemorts attaquent Poudlard ! Vous êtes à la Tour d’astronomie. Vous apercevez les Mangemorts au loin qui s'approchent dangereusement. ");

        System.out.println("Vous devez les attaquer de front avec Sectumsempra ! Si vous êtes de Serpentard, vous pouvez choisir de vous allier avec eux.");
        SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());

        while (wizard.getHealth() > 0 && mangemortModel.getHealth() > 0) {
            Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
            display.displayEnemyInfo(enemy);
            Scanner scanner = new Scanner(System.in);
            // Le wizard choisit son action
            System.out.println("Que voulez-vous faire ? \n1 attaquer\n2 se cacher\n3 Observer la pièce.");
            int choix = scanner.nextInt();
            if (choix == 1) {
                if (wizard.getHouse() == WizardModel.House.SLYTHERIN) {
                    System.out.println("Vous utilisez Sectumsempra contre vos ennemis de Poudlard ?");
                    System.out.println("1 Oui\n2 Non");
                    int reponse = scanner.nextInt();
                    if (reponse == 1) {
                        spellController.castSpell("Sectumsempra", enemy);
                    } else {
                        System.out.println("Vous décidez de ne pas attaquer.");
                    }
                } else {
                    spellController.castSpell("Sectumsempra", enemy);
                }
            } else if (choix == 2) {
                PotionController potionController = new PotionController();
                potionController.useHidePotion(wizard);
                // Corriger les dégâts infligés au wizard
                wizard.getHealth();
            } else if (choix == 3) {
                // Observation de la piece
                if (mangemortModel.getVisibility() < 1) {
                    System.out.println("Il fait trop sombre pour voir quoi que ce soit !");
                } else {
                    System.out.println("Vous pouvez voir le champ de bataille depuis la tour d’astronomie.");
                    System.out.println("Que voulez-vous observer ?\n1 Les Mangemorts\n2 Les environs");
                    int objet = scanner.nextInt();
                    if (objet == 1) {
                        System.out.println("Vous pouvez voir plusieurs Mangemorts qui s'approchent de la tour. Certains portent des baguettes magiques.");
                        System.out.println("Que voulez-vous observer ?\n1 Leur nombre\n2 Le type de leurs baguettes");
                        int observation = scanner.nextInt();
                        if (observation == 1) {
                            System.out.println("Il y a environ 10 Mangemorts qui approchent de la tour.");
                        } else if (observation == 2) {
                            System.out.println("Les Mangemorts ont des baguettes en bois d'if avec un crin de licorne.");
                        }
                    } else {
                        System.out.println("Choix invalide, veuillez choisir une action valide.");
                    }        // Mangemort attaque
                    if (mangemortModel.getVisibility() > 0 && tourAstronomie % 3 == 0) {
                        enemy.attack(attack, enemy);

                    }

                    // Le wizard a survécu à l'attaque
                    if (wizard.getHealth() > 0) {
                        // Gagne de l'expérience
                        RewardController.giveRewardToWizard(wizard);


                        // Le joueur doit choisir s'il veut se reposer pour récupérer de la santé ou continuer à avancer
                        System.out.println("Que voulez-vous faire ? \n1 Se reposer\n2 Continuer");
                        int choixRepos = scanner.nextInt();
                        if (choixRepos == 1) {
                            // Le wizard récupère de la santé
                            PotionController potionController = new PotionController();
                            potionController.useHealingPotion(wizard);
                        } else if (choixRepos == 2) {
                            // Continuer
                            tourAstronomie++;
                            System.out.println("Vous continuez à avancer !");
                        } else {
                            System.out.println("Choix invalide, vous continuez à avancer !");
                            tourAstronomie++;
                        }
                    }
                }

                // Le wizard a été vaincu
                if (wizard.getHealth() <= 0) {
                    System.out.println("Vous avez été vaincu par les Mangemorts. La bataille est perdue.");
                } else {
                    // Le Mangemort a été vaincu
                    System.out.println("Vous avez vaincu les Mangemorts ! Vous continuez votre chemin vers la suite de la bataille.");
                }
            }
        }
        Level7.level7(wizard,enemy);

    }
}
