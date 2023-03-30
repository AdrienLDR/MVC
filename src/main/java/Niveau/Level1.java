package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.TrollModel;
import View.*;

import java.util.List;
import java.util.Scanner;
public class Level1 {

    static List<SpellModel> knownSpells = SpellModel.getAvailableSpells();
    static String attack = AttackModel.getTrollAttacks().toString();

    public static void level1(WizardModel wizard, EnemyModel enemy) {

        RewardController.giveRewardToWizard(wizard);

        // Initialisation des variables du wizard
        int wizardHealth = wizard.getHealth();

        // Initialisation des variables du troll
        TrollModel trollModel = new TrollModel("Troll", 120, AttackModel.getTrollAttacks(),wizard);
        int trollHealth = trollModel.getHealth();
        int trollVisibility = trollModel.getVisibility();
        int lavabo = 0;
        SpellModel lumosSpell = null;
        SpellModel wingardiumLeviosa = null;
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
                // Correction : on crée le SpellController à l'extérieur de la boucle while
                SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());

                // Le wizard choisit son sort et le lance
                spellController.askSpellAndCast(trollModel);

                // On récupère les sorts choisis par le wizard
                lumosSpell = spellController.getSpell("Lumos");
                wingardiumLeviosa = spellController.getSpell("Wingardium Leviosa");

                // Si le sort Lumos a été utilisé et que le troll est caché, on le rend visible
                if (lumosSpell != null && trollModel.getVisibility() != 2) {
                    trollModel.setVisibility(2) ;
                    System.out.println("Vous pouvez voir distinctement le troll.");
                }

                // Si le sort Wingardium Leviosa a été utilisé et que deux lavabos ont été utilisés, on augmente les dégâts infligés
                if (wingardiumLeviosa != null && lavabo >= 2) {
                    wingardiumLeviosa.setDamage(wingardiumLeviosa.getDamage() * 7);
                    System.out.println("Cette attaque est très efficace.");
                }

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
                        itemController.useLavatoryItem(wizard, (TrollModel) enemy, lavabo, trollModel.getVisibility());
                        // Corriger les dégâts infligés au wizard et à l'ennemi
                        trollHealth = enemy.getHealth();
                        wizardHealth = wizard.getHealth();
                        lavabo =+ 2;
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
            enemy.attack(attack, enemy);
            if (wizard.getHealth() <= 0) {
                System.out.println("Vous êtes mort...");
            } else if (trollModel.getHealth() <= 0) {
                System.out.println("Vous avez vaincu le troll !");
            }

        }

    }
}