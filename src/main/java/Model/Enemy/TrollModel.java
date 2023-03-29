package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;

import java.util.List;

public class TrollModel extends EnemyModel {
    private int health;

    public TrollModel(String name, int health, List<AttackModel> trollAttacks) {
        super("Troll", health, AttackModel.getTrollAttacks());
        this.health = health;
    }

    public int getVisibility() {
        return 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
