package Controller;

import Model.Enemy.DementorModel;
import Model.Enemy.DoloresOmbrageModel;
import Model.EnemyModel;
import Model.WizardModel;
import Model.Enemy.TrollModel;
import View.ItemView;

import java.util.Scanner;

public class ItemController {
    public void useLavatoryItem(WizardModel wizard, TrollModel troll, int lavabo, int trollVisibility) {
        ItemView view = new ItemView();
        Scanner scanner = new Scanner(System.in);
        view.displayLavatoryItem();
        int action = scanner.nextInt();
        if (action == 1) {
            view.displayCleaningResult();
            troll.setHealth(troll.getHealth() - 2);
        } else if (action == 2) {
            view.displaySlipperyResult();
            troll.setHealth(troll.getHealth() - 4);
        } else {
            view.displayInvalidAction();
        }
    }

    public void useForestItem(WizardModel wizard, DementorModel enemy, int forest, int visibility) {
    }

    public void useBookItem(WizardModel wizard, DoloresOmbrageModel ombrageModel, int visibility) {
    }

    public void useParchmentItem(WizardModel wizard, DoloresOmbrageModel ombrageModel) {
    }
}
