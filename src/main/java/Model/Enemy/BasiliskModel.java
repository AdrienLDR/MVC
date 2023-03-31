package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class BasiliskModel extends EnemyModel {

    private static int health;
    private static int visibility;

    public BasiliskModel(String name, int health, List<AttackModel> basiliskAttack, WizardModel wizard) {
        super(name, health, basiliskAttack, wizard);
        this.visibility = visibility;
    }

    public int getVisibility() {
        return visibility;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        BasiliskModel.health = health;
    }
}
