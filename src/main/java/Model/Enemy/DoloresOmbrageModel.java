package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class DoloresOmbrageModel extends EnemyModel {
    private static int visibility;

    public DoloresOmbrageModel(String name, int health, List<AttackModel> doloresOmbrageAttacks, WizardModel wizard) {
        super("Dolores Ombrage", health, AttackModel.getOmbrageAttacks(),wizard);
    }

    public int getVisibility() {
        return visibility;
    }

    public static void setVisibility(int visibility) {
        DoloresOmbrageModel.visibility = visibility;
    }
}
