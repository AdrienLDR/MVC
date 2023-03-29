package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;

import java.util.List;

public class DétraqueurModel extends EnemyModel {
    public DétraqueurModel(String name, int health, List<AttackModel> détraqueurAttacks) {
        super("Dementors", 80, AttackModel.getDementorAttacks());
    }
}
