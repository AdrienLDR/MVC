package Model.Enemy;
import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class DementorModel extends EnemyModel {
    private int visibility;

    public DementorModel(String name, int health, List<AttackModel> detraqueurAttacks, WizardModel wizard) {
        super("Dementors", 80, AttackModel.getDementorAttacks(), wizard);
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
