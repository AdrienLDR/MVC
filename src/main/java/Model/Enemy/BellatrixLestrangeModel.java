package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;
import Model.WizardModel;

import java.util.List;

public class BellatrixLestrangeModel extends EnemyModel {
    public BellatrixLestrangeModel(String name, int health, List<AttackModel> bellatrixLestrangeAttacks, WizardModel wizard) {
        super("Bellatrix Lestrange", 130, AttackModel.getBellatrixAttacks(),wizard);
    }
}
