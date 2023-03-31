package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class DementorModel extends EnemyModel {
    private static int visibility;

    public DementorModel(String name, int health, List<AttackModel> detraqueurAttacks, WizardModel wizard) {
        super(name, health, detraqueurAttacks, wizard);

        this.visibility = visibility;
    }

    public int getVisibility() {
        return visibility;
    }
    public static void setVisibility(int visibility) {
        DementorModel.visibility = visibility;
    }

}