package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class VoldemortModel extends EnemyModel {
    public VoldemortModel(String name, int health, List<AttackModel> voldemortAttacks, WizardModel wizard) {
        super("Voldemort", 200, AttackModel.getVoldemortAttacks(),wizard);
    }
}
