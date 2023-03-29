package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;

import java.util.List;

public class VoldemortModel extends EnemyModel {
    public VoldemortModel(String name, int health, List<AttackModel> voldemortAttacks) {
        super("Voldemort", 200, AttackModel.getVoldemortAttacks());
    }
}
