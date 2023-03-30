package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class DoloresOmbrageModel extends EnemyModel {
    private int visibility;

    public DoloresOmbrageModel(String name, int health, List<AttackModel> doloresOmbrageAttacks, WizardModel wizard) {
        super("Dolores Ombrage", 90, AttackModel.getOmbrageAttacks(),wizard);
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
