package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;

import java.util.List;

public class DoloresOmbrageModel extends EnemyModel {
    public DoloresOmbrageModel(String name, int health, List<AttackModel> doloresOmbrageAttacks) {
        super("Dolores Ombrage", 90, AttackModel.getOmbrageAttacks());
    }
}
