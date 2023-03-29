package Controller;

import java.util.ArrayList;
import Model.PotionModel;
import Model.WizardModel;
import View.PotionView;
import java.util.List;

public class PotionController {
    private final List<PotionModel> potions;
    private final PotionView view;

    public PotionController() {
        potions = new ArrayList<>();
        potions.add(new PotionModel("Amortentia", "Love potion", "Causes powerful infatuation or obsession"));
        potions.add(new PotionModel("Draught of Living Death", "Sleeping potion", "Induces a deep, deathlike slumber"));
        potions.add(new PotionModel("Felix Felicis", "Luck potion", "Brings good luck and success in all endeavors"));
        potions.add(new PotionModel("Polyjuice Harrypotter.Potion", "Transformation potion", "Allows the drinker to assume the form of another person"));
        potions.add(new PotionModel("Skele-Gro", "Healing potion", "Regrows bones"));
        potions.add(new PotionModel("Veritaserum", "Truth potion", "Forces the drinker to tell the truth"));
        view = new PotionView();
    }

    public static int getHealAmount() {

        return 0;
    }

    public void displayAllPotions() {
        view.displayPotions(potions);
    }

    public void displayPotion(int potionIndex) {
        if (potionIndex < 0 || potionIndex >= potions.size()) {
            view.displayErrorMessage("Invalid potion index");
            return;
        }
        view.displayPotion(potions.get(potionIndex));
    }

    public void useHidePotion(WizardModel wizard) {
    }
}
