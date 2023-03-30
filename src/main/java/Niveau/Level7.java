package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.*;
import View.*;

import java.util.List;
import java.util.Scanner;

public class Level7 {
    static List<SpellModel> knownSpells = SpellModel.getAvailableSpells();
    static String attack = AttackModel.getVoldemortAttacks().toString();

    public static void level7(WizardModel wizard, EnemyModel enemy) {
        wizard.getHealth();
        VoldemortModel voldemortModel = new VoldemortModel("Voldemort", 300, AttackModel.getVoldemortAttacks(), wizard);
        BellatrixLestrangeModel bellatrixModel = new BellatrixLestrangeModel("Bellatrix Lestrange", 200, AttackModel.getBellatrixAttacks(), wizard);
        voldemortModel.getHealth();
        bellatrixModel.getHealth();
        int tourAstronomie = 0;
        SpellModel sectumsempra;
        System.out.println("Les forces du mal sont arrivées à Poudlard, Voldemort et Bellatrix Lestrange sont là ! Vous êtes à la Tour d’astronomie. Vous apercevez les deux ennemis qui s'approchent dangereusement. ");

        System.out.println("Vous devez les attaquer de front avec Sectumsempra ! Si vous êtes de Serpentard, vous pouvez choisir de vous allier avec eux.");
        SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());

        while (wizard.getHealth() > 0 && (voldemortModel.getHealth() > 0 || bellatrixModel.getHealth() > 0)) {
            Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
            Display.displayEnemyInfo(voldemortModel);
            Display.displayEnemyInfo(bellatrixModel);
            Scanner scanner = new Scanner(System.in);
            // Le wizard choisit son action
            System.out.println("Que voulez-vous faire ? \n1 attaquer\n2 se cacher\n3 Observer la pièce.");
            int choix = scanner.nextInt();
            if (choix == 1) {
                sectumsempra = spellController.getSpell("Sectumsempra");
                if (wizard.getHouse() == House.Serpentard) {
                    System.out.println("Vous utilisez Sectumsempra contre vos ennemis de Poudlard ?");
                    System.out.println("1 Oui\n2 Non");
                    int reponse = scanner.nextInt();
                    if (reponse == 1) {
                        if (wizard.getWand().getCore() == voldemortModel.getWand().getCore()) {
                            System.out.println("Votre baguette et celle de Voldemort partagent le même coeur !");
                            System.out.println("Les effets de votre sort sont imprévisibles...");
                            System.out.println("Vous avez une chance de le blesser mortellement mais vous prenez aussi le risque de vous blesser !");
                            System.out.println("Etes-vous sûr de vouloir lancer Sectumsempra ?");
                            System.out.println("1 Oui\n2 Non");
                            int choixSort = scanner.nextInt();
                            if (choixSort == 1) {
                                sectumsempra.cast(voldemortModel);
                            }
                        } else {
                            sectumsempra.cast(voldemortModel);
                        }
                    } else {
                        System.out.println("Vous décidez de ne pas attaquer.");
                    }
                } else {
                    if (wizard.getWand().getCore() == voldemortModel.getWand().getCore()) {
                        System.out.println("Votre baguette et celle de Voldemort partagent le même coeur !");
                        System.out.println("Les effets de votre sort sont imprévisibles...");
                        System.out.println("Vous avez une chance de le blesser mortellement mais vous prenez aussi le risque de vous blesser !");
                        System.out.println("Etes-vous sûr de vouloir lancer Sectumsempra ?");
                        System.out.println("1 Oui\n2 Non");
                        int choixSort = scanner.nextInt();
                        if (choixSort == 1) {
                            sectumsempra.cast(voldemortModel);
                        }
                    } else {
                        sectumsempra.cast(voldemortModel);
                    }
                }
// Voldemort et Bellatrix attaquent à leur tour
                voldemortModel.attack(wizard);
                bellatrixModel.attack(wizard);
            } else if (choix == 2) {
                System.out.println("Vous vous cachez derrière une caisse. Les ennemis ne vous voient pas.");
            } else if (choix == 3) {
                if (tourAstronomie == 0) {
                    System.out.println("Vous observez la pièce et remarquez une caisse remplie de potions sur votre gauche.");
                    tourAstronomie++;
                } else {
                    System.out.println("Vous n'avez rien trouvé d'intéressant.");
                }
            } else {
                System.out.println("Choix invalide !");
            }
        }
        if (wizard.getHealth() <= 0) {
            System.out.println("Vous êtes vaincu...");
        } else if (voldemortModel.getHealth() <= 0 && bellatrixModel.getHealth() <= 0) {
            System.out.println("Vous avez vaincu Voldemort et Bellatrix Lestrange !");
            wizard.addExperience(500);
            System.out.println("+500 points d'expérience !");
        } else if (voldemortModel.getHealth() <= 0) {
            System.out.println("Vous avez vaincu Voldemort !");
            wizard.addExperience(250);
            System.out.println("+250 points d'expérience !");
        } else {
            System.out.println("Vous avez vaincu Bellatrix Lestrange !");
            wizard.addExperience(250);
            System.out.println("+250 points d'expérience !");
        }
    }
}