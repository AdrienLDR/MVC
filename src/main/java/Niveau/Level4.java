package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.DoloresOmbrageModel;
import Model.Enemy.VoldemortModel;
import Model.Enemy.PeterPettigrewModel;
import View.*;

import java.util.List;
import java.util.Scanner;

public class Level4 {
    static List<SpellModel> knownSpells = SpellModel.getAvailableSpells();
    static String attack = AttackModel.getVoldemortAttacks().toString();

    public static void level4(WizardModel wizard, EnemyModel voldemort, EnemyModel peter ) {

        Display display = new Display();

        VoldemortModel voldemortModel = new VoldemortModel("Voldemort", 400, AttackModel.getVoldemortAttacks(), wizard,"en Plume de Phoenix");
        PeterPettigrewModel peterPettigrewModel = new PeterPettigrewModel("Peter Pettigrew", 120, AttackModel.getPettigrewAttacks(), wizard);
        voldemortModel.getHealth();
        peterPettigrewModel.getHealth();

        System.out.println("Vous êtes maintenant dans un cimetière sombre et sinistre, entouré de tombes lugubres. Vous remarquez la présence de Voldemort et de Peter Pettigrew.");

        System.out.println("Voldemort s'approche de vous en souriant, tandis que Peter Pettigrew est en train de préparer le Portolion pour leur fuite.\n Vous réalisez que votre seule chance de survie est d'attirer le Portolion à vous en utilisant le sort 'Accio'.");

        SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());

        while (wizard.getHealth() > 0 && voldemortModel.getHealth() > 0 && peterPettigrewModel.getHealth() > 0) {
            Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
            display.displayEnemyInfo(voldemort);
            display.displayEnemyInfo(peter);

            Scanner scanner = new Scanner(System.in);
            // Le wizard choisit son action
            System.out.println("Que voulez-vous faire ? \n1 attaquer Voldemort\n2 attaquer Peter Pettigrew\n3 Utiliser des potions");
            int choix = scanner.nextInt();
            if (choix == 1) {
                spellController.askSpellAndCast(voldemort);
            } else if (choix == 2) {
                spellController.askSpellAndCast(peter);
            } else if (choix == 3) {
                PotionController potionController = new PotionController();
                potionController.useHidePotion(wizard);
                wizard.getHealth();
            } else {
                System.out.println("Choix invalide.");
                return;
            }
            if (voldemortModel.getHealth() >= 0 ) {
                voldemort.attack(attack, voldemort);
            }
            if (peterPettigrewModel.getHealth() >= 0 ) {
                peter.attack(attack, peter);}


            if (wizard.getHealth() <= 0) {
                System.out.println("Vous êtes mort...");
            } else if (voldemortModel.getHealth() <= 0 && peterPettigrewModel.getHealth() <= 0) {
                System.out.println("Félicitations ! Vous avez réussi à attirer le Portolion à vous et à vaincre Voldemort et Peter Pettigrew !");
                RewardController.giveRewardToWizard(wizard);
                RewardController.giveRewardToWizard(wizard);


            }
        }
        Level5.level5(wizard,new DoloresOmbrageModel("Dolores Ombrage", 250, AttackModel.getOmbrageAttacks(), wizard));

    }
}


