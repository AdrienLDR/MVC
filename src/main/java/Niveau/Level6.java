package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.MangemortModel;
import View.*;

import java.util.List;
import java.util.Scanner;

public class Level6 {
    SpellModel spellModel = new SpellModel("","",0,0);

    List<SpellModel> knownSpells = spellModel.getKnownSpells();
    static String attack = AttackModel.getDeathEaterAttacks().toString();


    public void level6(WizardModel wizard, EnemyModel enemy) {

        Display display = new Display();

        wizard.getHealth();
        MangemortModel mangemortModel = new MangemortModel("Mangemort", 300, AttackModel.getDeathEaterAttacks(), wizard);
        mangemortModel.getHealth();
        mangemortModel.getVisibility();
        int tourAstronomie = 0;
        SpellModel sectumsempra = new SpellModel("Sectumsempra", "Sortilège de mutilation", 80, 70);
        knownSpells.add(sectumsempra);

        System.out.println("Les Mangemorts attaquent Poudlard ! Vous êtes à la Tour d’astronomie. Vous apercevez les Mangemorts au loin qui s'approchent dangereusement.");

        // Si le joueur est de Serpentard, il peut choisir de se rallier aux Mangemorts
        if (wizard.getHouse() == WizardModel.House.SLYTHERIN) {
            System.out.println("Voulez-vous vous allier avec les Mangemorts ?\n1 Oui\n2 Non");
            Scanner scanner = new Scanner(System.in);
            int allianceChoice = scanner.nextInt();
            if (allianceChoice == 1) {
                // Le joueur choisit de s'allier avec les Mangemorts
                System.out.println("Vous avez choisi de vous allier avec les Mangemorts !");
                mangemortModel = new MangemortModel("Sorciers", 200, AttackModel.getDeathEaterAttacks(), wizard);
            } else {
                // Le joueur choisit de combattre les Mangemorts
                System.out.println("Vous avez choisi de combattre les Mangemorts !");
            }
        }

        System.out.println("Vous devez les attaquer de front avec Sectumsempra !");


        SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());

        while (wizard.getHealth() > 0 && mangemortModel.getHealth() > 0) {
            Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
            display.displayEnemyInfo(enemy);
            Scanner scanner = new Scanner(System.in);
            // Le wizard choisit son action
            System.out.println("Que voulez-vous faire ? \n1 attaquer\n2 Utiliser une potion\n3 Observer la pièce.");
            int choix = scanner.nextInt();

            if (choix == 1) {
                if (wizard.getHouse() == WizardModel.House.SLYTHERIN) {
                    System.out.println("Vous utilisez un sort contre vos ennemis de Poudlard ?");
                    System.out.println("1 Oui\n2 Non");
                    int reponse = scanner.nextInt();
                    if (reponse == 1) {
                        spellController.askSpellAndCast(enemy);
                    } else {
                        System.out.println("Vous décidez de ne pas attaquer.");
                    }
                } else {
                    spellController.askSpellAndCast(enemy);
                }
            } else if (choix == 2) {
                PotionController potionController = new PotionController();
                potionController.useHidePotion(wizard);
                // Corriger les dégâts infligés au wizard
                wizard.getHealth();}

            else if (choix == 3) {
                    // Ajouter des interactions avec le décor
                    System.out.println("Vous observez la pièce avec attention.");
                    System.out.println("Vous remarquez un livre posé sur une étagère, un vase en porcelaine sur une commode, et un portrait ancien accroché au mur.");
                    System.out.println("Que voulez-vous faire ?");
                    System.out.println("1. Lire le livre");
                    System.out.println("2. Examiner le vase");
                    System.out.println("3. Regarder le portrait");

                    int reponse = scanner.nextInt();

                    switch (reponse) {
                        case 1:
                            System.out.println("Vous ouvrez le livre et découvrez qu'il s'agit d'un grimoire de sorts anciens.");
                            break;
                        case 2:
                            System.out.println("Vous examinez le vase et remarquez qu'il est très fragile.");
                            break;
                        case 3:
                            System.out.println("Vous regardez le portrait et remarquez qu'il représente un sorcier barbu portant un chapeau pointu.");
                            break;
                        default:
                            System.out.println("Option invalide.");
                            break;
                    }

            }

            if (mangemortModel.getHealth()>0) {
                mangemortModel.attack(attack, enemy);
            }

            if (wizard.getHealth() <= 0) {
                System.out.println("Vous avez été vaincu par les Mangemorts. La bataille est perdue.");
                break;
            }

            if (mangemortModel.getHealth() <= 0) {
                System.out.println("Vous avez vaincu les Mangemorts ! Vous continuez votre chemin vers la suite de la bataille.");
                break;
            }
        }
    }
}
