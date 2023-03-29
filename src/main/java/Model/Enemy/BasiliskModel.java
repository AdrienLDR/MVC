package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;

import java.util.List;

public class BasiliskModel extends EnemyModel {
    public BasiliskModel(String name, int health,List<AttackModel> basiliskAttack) {
        super("Basilisk", 120, AttackModel.getBasiliskAttacks());
    }
}
