package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class TrollModel extends EnemyModel {
    private static int health;
    private static int visibility;

    public TrollModel(String name, int health, List<AttackModel> trollAttacks, WizardModel wizard) {
        super("Troll", health, trollAttacks, wizard);
        this.health = health;
        this.visibility = visibility;
    }

    // Getter pour la visibilité du troll
    public int getVisibility() {
        return visibility;
    }

    // Setter pour la visibilité du troll
    public static void setVisibility(int visibility) {
        TrollModel.visibility = visibility;
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
