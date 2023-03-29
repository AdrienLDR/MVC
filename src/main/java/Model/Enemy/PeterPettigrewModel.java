package Model.Enemy;

import Model.AttackModel;
import Model.EnemyModel;

import java.util.List;

public class PeterPettigrewModel extends EnemyModel {
    public PeterPettigrewModel(String name, int health, List<AttackModel> peterPettigrewAttacks) {
        super("Peter Pettigrew", 60, AttackModel.getPettigrewAttacks());
    }
}
