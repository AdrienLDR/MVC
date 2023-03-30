package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class DementorModel extends EnemyModel {
    public DementorModel(String name, int health, List<AttackModel> detraqueurAttacks, WizardModel wizard) {
        super("Dementors", 80, AttackModel.getDementorAttacks(),wizard);
    }
}
