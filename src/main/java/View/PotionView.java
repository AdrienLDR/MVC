package View;

import Model.PotionModel;
import java.util.List;

public class PotionView {
    public void displayPotions(List<PotionModel> potions) {
        System.out.println("Here are the available potions:");
        for (PotionModel potion : potions) {
            System.out.println(potion.getPotionName() + " (" + potion.getType() + ") - " + potion.getEffect());
        }
    }

    public void displayPotion(PotionModel potion) {
        System.out.println("Potion details:");
        System.out.println("Name: " + potion.getPotionName());
        System.out.println("Type: " + potion.getType());
        System.out.println("Effect: " + potion.getEffect());
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
