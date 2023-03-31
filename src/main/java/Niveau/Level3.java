package Niveau;

import Controller.*;
import Model.*;
import Model.Enemy.DementorModel;
import Model.Enemy.PeterPettigrewModel;
import Model.Enemy.VoldemortModel;
import View.*;

import java.util.List;
import java.util.Scanner;

public class Level3 {
    SpellModel spellModel = new SpellModel("","",0,0);

    List<SpellModel> knownSpells = spellModel.getKnownSpells();    static String attack = AttackModel.getDementorAttacks().toString();

    public void level3(WizardModel wizard, EnemyModel enemy) {

        Display display = new Display();

        wizard.getHealth();
        DementorModel dementorModel = new DementorModel("Dementor", 300, AttackModel.getDementorAttacks(), wizard);
        dementorModel.getHealth();

        int reveilPet = 0;
        int eveilPet = 0;
        int veilPet = 0;

        System.out.println("Vous êtes dans la forêt interdite. Vous entendez des cris et des pleurs, et vous voyez des ombres s'approcher de vous. Ce sont les Détraqueurs, et ils sont très dangereux.");

        System.out.println("Les Détraqueurs se rapprochent de vous, et vous commencez à sentir leur souffle glacé sur votre visage. Vous sortez votre baguette magique et vous vous préparez à l'affronter.");

            SpellController spellController = new SpellController(wizard, knownSpells, new SpellView());

                while (wizard.getHealth() > 0 && dementorModel.getHealth() > 0) {
                    Display.displayWizardInfo(wizard.getName(), wizard.getHealth(), wizard.getMana(), wizard.getExperience());
                    display.displayEnemyInfo(enemy);

                    int forest = reveilPet + eveilPet + veilPet;

                    if (forest == 3) {
                        System.out.println("Vous maitrisez maitenant le sort Expecto Patronum");

                        knownSpells.add(new SpellModel("Expecto Patronum", "Sortilège du Patronus", 50, 40));
                    }

                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Que voulez-vous faire ? \n1 attaquer\n2 Utiliser une potion\n3 Observer la forêt.");
                    int choix = scanner.nextInt();
                    if (choix == 1) {
                        spellController.askSpellAndCast(enemy);

                    } else if (choix == 2) {
                        PotionController potionController = new PotionController();
                        potionController.useHidePotion(wizard);
                        wizard.getHealth();
                    } else if (choix == 3) {
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
                                System.out.println("Vous commencer a realiser quelque chose en vous.");

                                if (reveilPet != 1) {
                                    reveilPet++;
                                }
                            } else if (objet == 2) {
                                System.out.println("Vous vous aprochez doucement d'un arbre");
                                System.out.println("Il evoque quelque chose au fond de votre memoire.");

                                if (eveilPet != 1) {
                                    eveilPet++;
                                }
                            } else if (objet == 3) {
                                System.out.println("Vous voyez une clairière au loin, mais elle semble dangereuse.");
                                System.out.println("Voulez-vous y aller ? \n1 oui\n2 non");
                                int response = scanner.nextInt();
                                if (response == 1) {
                                    System.out.println("Vous entrez dans la clairière et vous voyez un objet brillant au sol.");
                                    System.out.println("1) Aller vers l'objet");
                                    System.out.println("2) Rester sur vos gardes");
                                    int action = scanner.nextInt();
                                    if (action == 1) {
                                        System.out.println("Vous vous rapprochez de l'objet et vous vous rendez compte qu'il s'agit d'une flaque d'eau qui n'est rien de plus que le reflet de vous même.");
                                        System.out.println("Une verite vous apparait maintenant comme evidente.");
                                        System.out.println("Vous en etes capable mais il vous manque peut-être des indices pour reussir");

                                        if (veilPet != 1) {
                                            veilPet++;
                                        }

                                    } else if (action == 2) {
                                        System.out.println("Vous restez sur vos gardes et vous observez les alentours.");
                                    }
                                } else if (response == 2) {
                                    System.out.println("Vous décidez de ne pas prendre de risques et vous restez dans la forêt.");
                                }
                            }
                        }
                    }
                    if (enemy.getHealth() > 0) {
                        enemy.attack(attack, enemy);
                    }
                    if (wizard.getHealth() <= 0) {
                        System.out.println("Vous êtes mort...");
                    } else if (dementorModel.getHealth() <= 0) {
                        System.out.println("Vous avez vaincu le troll !");
                    }
                }
                RewardController.giveRewardToWizard(wizard);
            }
        }
