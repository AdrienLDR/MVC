package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;

import java.util.List;

public class BellatrixLestrangeModel extends EnemyModel {
    public BellatrixLestrangeModel(String name, int health, List<AttackModel> bellatrixLestrangeAttacks) {
        super("Bellatrix Lestrange", 130, AttackModel.getBellatrixAttacks());
    }
}
