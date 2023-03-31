package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class VoldemortModel extends EnemyModel {
    private String Core;

    public VoldemortModel(String name, int health, List<AttackModel> voldemortAttacks, WizardModel wizard, String Core) {
        super("Voldemort", health, AttackModel.getVoldemortAttacks(), wizard);
        this.Core = Core;
    }

    public String getCore() {
        return Core;
    }
}
