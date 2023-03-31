package Controller;

import Model.RewardModel;
import Model.WizardModel;
import java.util.Scanner;

public class RewardController {
    public static void giveRewardToWizard(WizardModel wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vous avez accompli une tâche difficile. Vous pouvez maintenant choisir votre récompense :");
        System.out.println("1) +200 de vie");
        System.out.println("2) +100 de mana");
        int rewardChoice = scanner.nextInt();
        RewardModel reward = null;

        if (rewardChoice == 1) {
            reward = new RewardModel(200, 0);
        } else if (rewardChoice == 2) {
            reward = new RewardModel(0, 100);
        } else {
            System.out.println("Choix invalide.");
            return;
        }

        wizard.addHealth(reward.getHealthReward());
        wizard.addMana(reward.getManaReward());
        wizard.gainExperience(1);
        System.out.println("Vous avez reçu votre récompense !");
    }
}
