package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class MangemortModel extends EnemyModel {
    public MangemortModel(String name, int health, List<AttackModel> mangemortAttacks, WizardModel wizard) {
        super("Mangemort", 110, AttackModel.getDeathEaterAttacks(),wizard);
    }
}
