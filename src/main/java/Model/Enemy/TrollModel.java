package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;

import java.util.List;

public class TrollModel extends EnemyModel {
    private static int health;

    public TrollModel(String name, int health, List<AttackModel> trollAttacks) {
        super("Troll", health, AttackModel.getTrollAttacks());
        this.health = health;
    }

    public static int getVisibility() {
        return 0;
    }

    // Getter pour la vie du troll
    public int getHealth() {
        return health;
    }

    // Setter pour la vie du troll
    public void setHealth(int health) {
        TrollModel.health = health;
    }
}
