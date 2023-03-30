package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class DétraqueurModel extends EnemyModel {
    public DétraqueurModel(String name, int health, List<AttackModel> détraqueurAttacks, WizardModel wizard) {
        super("Dementors", 80, AttackModel.getDementorAttacks(),wizard);
    }
}
