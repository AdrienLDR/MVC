package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;

import java.util.List;

public class MangemortModel extends EnemyModel {
    public MangemortModel(String name, int health, List<AttackModel> mangemortAttacks) {
        super("Mangemort", 110, AttackModel.getDeathEaterAttacks());
    }
}
