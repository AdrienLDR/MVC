package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class BasiliskModel extends EnemyModel {

    private static int visibility;

    public BasiliskModel(String name, int health, List<AttackModel> basiliskAttack, WizardModel wizard) {
        super(name, health, basiliskAttack, wizard);
        this.visibility = visibility;
    }

    public int getVisibility() {
        return visibility;
    }
}
